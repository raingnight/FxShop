package entity;

import java.util.HashMap;
import java.util.Map;

public class User {
	String username;
	int id;
	String password;
	String email;
	Map<Integer,Integer> cart = new HashMap<Integer, Integer>();
	
	public User() {
		super();
	}
	
	public User(String username,String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Map<Integer, Integer> getCart() {
		return cart;
	}

	public void setCart(Map<Integer, Integer> cart) {
		this.cart = cart;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}	
	
	public String toString() {
		return "name: "+username+" pwd: "+password;
	}
}
