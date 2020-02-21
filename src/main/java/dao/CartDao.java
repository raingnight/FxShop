package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entity.Product;
import util.DBUtils;

public class CartDao {
	public void addToCart(int u_id,int p_id,int num) throws SQLException {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
		conn = DBUtils.getConn();
		String sql = "insert into cart values(?,?,?)";
		prep = conn.prepareStatement(sql);
		prep.setInt(1,u_id);
		prep.setInt(2, p_id);
		prep.setInt(3, num);
		prep.executeUpdate();
		} catch (SQLException  e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, prep, conn);
		}		
	
	}
	
	public Map<Product, Integer> viewCart(int u_id) throws SQLException {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		ProductDao productDao = new ProductDao();
		Product product = null;
		int number;
		Map<Product, Integer> goods_list = new HashMap<Product, Integer>();
		
		try {
		conn = DBUtils.getConn();
		String sql = "SELECT p_id ,COUNT(p_id) AS number FROM cart WHERE u_id = ? GROUP BY p_id;";
		prep = conn.prepareStatement(sql);
		prep.setInt(1,u_id);
		res = prep.executeQuery();
		while(res.next()) {
			product = productDao.FindById(res.getInt("p_id"));
			number = res.getInt("number");
			goods_list.put(product, number);
		}
		
		} catch (SQLException  e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, prep, conn);
		}	
		return goods_list;
	}
}
