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
	
//	service方法
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		获取URI
		String uri = request.getRequestURI();		
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		String goods = path.substring(0,5);
		System.out.println(goods);
//截取请求资源路径并执行相应的操作		
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
			System.out.println("添加成功");
//			response.sendRedirect("addPro.jsp");
			request.setAttribute("fina", "<script>alert('添加成功');</script>");
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
			System.out.println("添加成功");
			session.removeAttribute("pid");
			String addinfo = "<script>alert('添加成功！');</script>";
			request.setAttribute("addinfo", addinfo);
		} catch (SQLException e) {
			e.printStackTrace();
			String addinfo = "<script>alert('添加失败,请重试！');</script>";
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
//	获取商品列表方法
	public void processList(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
//		编码设置
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		获取session对象
		HttpSession session = request.getSession();
//		获取session中绑定的对象
		Object obj = session.getAttribute("user");
		/*判断是否有绑定对象
		 * 有则是已登录
		 * 无则是未登录，跳转登录页请求登录
		  */
//		if(obj==null) {
//			System.out.println(session.getId());
//			response.sendRedirect("login.jsp");
//			return ;
//		}
//		开始获取所有商品
		ProductDao productDao = new ProductDao();
		List<Product> products = new ArrayList<Product>();
		try {
			products = productDao.FindAll();
//			获取成功，将数据绑定到request对象上转发给商品页
			request.setAttribute("products", products);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
//	登录
	public void processLogin(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
//		编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		获取输入的账号和密码
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
//		存在空进行提示
		if(uname==""||pwd=="") {
			request.setAttribute("login_failed", "用户名及密码不能为空！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}	

		try {
//			通过用户名查找用户
			UserDao userDao = new UserDao();
			User u = null;
			u = userDao.FindByName(uname);
//			查找到且密码正确
			if(u!=null&&u.getPassword().equals(pwd)) {
				System.out.println("登录成功");
//				创建session对象并将登录的用户的信息绑定到session上
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(900);
				session.setAttribute("user", u);
//				登录成功，重定向到商品页
				response.sendRedirect("list.do");
			}
//			没有查找到用户
			else if(u==null) {
				request.setAttribute("login_failed", "账号不存在！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("login_failed", "账号或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	登录
	public void processLogon(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
//		编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//	获取输入的信息	
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
//		判断信息是否为空，为空进行提示
		if(uname==""||pwd=="") {
			request.setAttribute("logon_failed", "用户名及密码不能为空！");
			request.getRequestDispatcher("logon.jsp").forward(request, response);
		}
//		不为空进行注册
		else {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername(uname);
		user.setPassword(pwd);
		user.setEmail(email);	
		try {
//			用户名不可以重复
			if(userDao.FindByName(uname)!=null) {
				request.setAttribute("logon_failed", "用户名已存在，请重新输入！");
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
