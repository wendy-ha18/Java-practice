package product.foreach;

public class Productlist {
	private int id;
	private String name;
	private int price;
	private String category;
	private String status;
	
	
	
	public Productlist(int id, String name, int price, String category, String status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.status = status;
	}
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
}
