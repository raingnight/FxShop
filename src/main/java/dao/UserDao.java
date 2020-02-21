package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import util.DBUtils;

public class UserDao {
	
	public User FindById(int id) throws SQLException {	
		User user = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		
		try {
		conn = DBUtils.getConn();
		String sql = "select * from userinfo where id = ?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, id);
		res = prep.executeQuery();
		if(res.next()) {
			user = new User();
			user.setUsername(res.getString("name"));
			user.setId(id);
			user.setEmail(res.getString("email"));
			user.setPassword(res.getString("password"));
		}
				
		} catch (SQLException  e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(res, prep, conn);
		}	
		return user;
		
	}
	public User FindByName(String name) throws SQLException {	
		User user = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		
		try {
		conn = DBUtils.getConn();
		String sql = "select * from userinfo where name = ?";
		prep = conn.prepareStatement(sql);
		prep.setString(1,name);
		res = prep.executeQuery();
		if(res.next()) {
			user = new User();
			user.setUsername(name);
			user.setId(res.getInt("id"));
			user.setEmail(res.getString("email"));
			user.setPassword(res.getString("password"));
		}
				
		} catch (SQLException  e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(res, prep, conn);
		}	
		return user;	
	}
	
	public void AddUser(User u) throws SQLException {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConn();
			String sql = "insert into userinfo values(?,null,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1, u.getUsername());
			prep.setString(2, u.getPassword());
			prep.setString(3, u.getEmail());
			prep.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.close(null, prep, conn);
		}
	}
	
	public void DelUser(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConn();
			String sql = "delete from userinfo where id = ?";
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
