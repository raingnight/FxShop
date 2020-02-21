package web;

import java.sql.SQLException;
import java.util.Map;

import dao.UserDao;
import entity.User;

public class te {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		try {
			User user = dao.FindByName("fx");
			Map<Integer,Integer> c = user.getCart();
			c.put(1, 2);
			c.put(2, 4);
			for(Map.Entry<Integer, Integer> a : c.entrySet()) {
				System.out.println(a.getKey()+" "+a.getValue());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
