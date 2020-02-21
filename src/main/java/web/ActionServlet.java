package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.ProductDao;
import dao.UserDao;
import entity.Product;
import entity.User;

public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
//	service����
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		��ȡURI
		String uri = request.getRequestURI();		
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		String goods = path.substring(0,5);
		System.out.println(goods);
//��ȡ������Դ·����ִ����Ӧ�Ĳ���		
		if("/login".equals(path)) {
			processLogin(request, response);
		}
		if("/logon".equals(path)) {
			processLogon(request, response);
		}
		if("/list".equals(path)){
			System.out.println("list");
			processList(request, response);
		}
		if("/good".equals(goods)) {
			processDetail(request, response);
		}
		if("/cart".equals(path)) {
			processAddToCart(request,response);
		}
		if("/viewcart".equals(path)) {
			processViewCart(request,response);
		}
		if("/addpro".equals(path)) {
			processAddPro(request,response);
		}
	}
	private void processAddPro(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	
		ProductDao productDao  = new ProductDao();
		Product product = new Product();
		
		product.setP_name(request.getParameter("pro_name"));
		product.setDescription(request.getParameter("pro_desc"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setNum(Integer.parseInt(request.getParameter("number")));
		product.setStatus( request.getParameter("status"));
		
		try {
			productDao.AddProduct(product);
			System.out.println("��ӳɹ�");
//			response.sendRedirect("addPro.jsp");
			request.setAttribute("fina", "<script>alert('��ӳɹ�');</script>");
			request.getRequestDispatcher("addPro.jsp").forward(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	public void processViewCart(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if(u==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		CartDao cartDao = new CartDao();
		try {
			Map<Product, Integer> cart = cartDao.viewCart(u.getId());
			request.setAttribute("cart", cart);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void processAddToCart(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if(u==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		int p_id = (Integer) session.getAttribute("pid");
		CartDao cartDao = new CartDao();
		try {
			cartDao.addToCart(u.getId(), p_id, 1);
			System.out.println("��ӳɹ�");
			session.removeAttribute("pid");
			String addinfo = "<script>alert('��ӳɹ���');</script>";
			request.setAttribute("addinfo", addinfo);
		} catch (SQLException e) {
			e.printStackTrace();
			String addinfo = "<script>alert('���ʧ��,�����ԣ�');</script>";
			request.setAttribute("addinfo", addinfo);
		}
		request.getRequestDispatcher("goods"+p_id+".do").forward(request, response);
	}
	public void processDetail(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();	
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		String goodsId = path.substring(6,7);
		
		ProductDao productDao = new ProductDao();
		try {
			Product product = productDao.FindById(Integer.parseInt(goodsId));
			HttpSession session = request.getSession();
			session.setAttribute("pid", product.getP_id());
			request.setAttribute("product", product);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	��ȡ��Ʒ�б���
	public void processList(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
//		��������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		��ȡsession����
		HttpSession session = request.getSession();
//		��ȡsession�а󶨵Ķ���
		Object obj = session.getAttribute("user");
		/*�ж��Ƿ��а󶨶���
		 * �������ѵ�¼
		 * ������δ��¼����ת��¼ҳ�����¼
		  */
//		if(obj==null) {
//			System.out.println(session.getId());
//			response.sendRedirect("login.jsp");
//			return ;
//		}
//		��ʼ��ȡ������Ʒ
		ProductDao productDao = new ProductDao();
		List<Product> products = new ArrayList<Product>();
		try {
			products = productDao.FindAll();
//			��ȡ�ɹ��������ݰ󶨵�request������ת������Ʒҳ
			request.setAttribute("products", products);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
//	��¼
	public void processLogin(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
//		����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		��ȡ������˺ź�����
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
//		���ڿս�����ʾ
		if(uname==""||pwd=="") {
			request.setAttribute("login_failed", "�û��������벻��Ϊ�գ�");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}	

		try {
//			ͨ���û��������û�
			UserDao userDao = new UserDao();
			User u = null;
			u = userDao.FindByName(uname);
//			���ҵ���������ȷ
			if(u!=null&&u.getPassword().equals(pwd)) {
				System.out.println("��¼�ɹ�");
//				����session���󲢽���¼���û�����Ϣ�󶨵�session��
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(900);
				session.setAttribute("user", u);
//				��¼�ɹ����ض�����Ʒҳ
				response.sendRedirect("list.do");
			}
//			û�в��ҵ��û�
			else if(u==null) {
				request.setAttribute("login_failed", "�˺Ų����ڣ�");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("login_failed", "�˺Ż��������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	��¼
	public void processLogon(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
//		����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//	��ȡ�������Ϣ	
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
//		�ж���Ϣ�Ƿ�Ϊ�գ�Ϊ�ս�����ʾ
		if(uname==""||pwd=="") {
			request.setAttribute("logon_failed", "�û��������벻��Ϊ�գ�");
			request.getRequestDispatcher("logon.jsp").forward(request, response);
		}
//		��Ϊ�ս���ע��
		else {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername(uname);
		user.setPassword(pwd);
		user.setEmail(email);	
		try {
//			�û����������ظ�
			if(userDao.FindByName(uname)!=null) {
				request.setAttribute("logon_failed", "�û����Ѵ��ڣ����������룡");
				request.getRequestDispatcher("logon.jsp").forward(request, response);
			}
			else {
			userDao.AddUser(user);
			response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
}
