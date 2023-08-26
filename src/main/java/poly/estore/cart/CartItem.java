package poly.estore.cart;

import lombok.Data;
import lombok.NoArgsConstructor;
import poly.estore.entity.Product;

public class CartItem {
	Integer id;
	String name;
	double price;
	int quantity = 1;
	String image;
	public double getAmount() {
		return quantity*price;
	}
	public CartItem(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
	}
	public CartItem() {
		super();
	}
	public CartItem(Integer id, String name, double price, int quantity, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
	
}
