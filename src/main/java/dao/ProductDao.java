package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import entity.User;
import util.DBUtils;
public class ProductDao {
	
	public Product FindByName(String name) throws SQLException {
		Product pro = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		
		try {
		conn = DBUtils.getConn();
		String sql = "select * from product where name = ?";
		prep = conn.prepareStatement(sql);
		prep.setString(1,name);
		res = prep.executeQuery();
		if(res.next()) {
			pro = new Product();
			pro.setP_name(name);
			pro.setP_id(res.getInt("id"));
			pro.setDescription(res.getString("desc"));
			pro.setNum(res.getInt("num"));
			pro.setPrice(res.getFloat("price"));
			pro.setStatus(res.getString("status"));
		}
				
		} catch (SQLException  e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(res, prep, conn);
		}	
		return pro;
	}
	
	public Product FindById(int id) throws SQLException {
		Product pro = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		
		try {
		conn = DBUtils.getConn();
		String sql = "select * from product where id = ?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1,id);
		res = prep.executeQuery();
		if(res.next()) {
			pro = new Product();
			pro.setP_name(res.getString("name"));
			pro.setP_id(id);
			pro.setDescription(res.getString("desc"));
			pro.setNum(res.getInt("num"));
			pro.setPrice(res.getFloat("price"));
			pro.setStatus(res.getString("status"));
		}
				
		} catch (SQLException  e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(res, prep, conn);
		}	
		return pro;
	}
	
	public List<Product> FindAll() throws SQLException {
		Product pro = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		List<Product> products = new ArrayList<Product>();
		
		try {
		conn = DBUtils.getConn();
		String sql = "select * from product";
		prep = conn.prepareStatement(sql);
		res = prep.executeQuery();
		while(res.next()) {
			pro = new Product();
			pro.setP_name(res.getString("name"));
			pro.setP_id(res.getInt("id"));
			pro.setDescription(res.getString("desc"));
			pro.setNum(res.getInt("num"));
			pro.setPrice(res.getFloat("price"));
			pro.setStatus(res.getString("status"));
			products.add(pro);
		}
				
		} catch (SQLException  e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(res, prep, conn);
		}	
		return products;
	}
	
	public void AddProduct(Product p) throws SQLException {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConn();
			String sql = "insert into product values(null,?,?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1, p.getP_name());
			prep.setString(2, p.getDescription());
			prep.setFloat(3, p.getPrice());
			prep.setInt(4, p.getNum());
			prep.setString(5, p.getStatus());
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.close(null, prep, conn);
		}
	}
	
	public void DelProduct(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConn();
			String sql = "delete from product where id = ?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.close(null, prep, conn);
		}
	}
}
