package entity;

public class Product {
	String p_name;
	float price;
	int p_id;
	String description;
	int num;
	String status;	
	
	public Product() {
		super();
	}

	public Product(String p_name, float price, int p_id, String description, int num, String status) {
		super();
		this.p_name = p_name;
		this.price = price;
		this.p_id = p_id;
		this.description = description;
		this.num = num;
		this.status = status;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
