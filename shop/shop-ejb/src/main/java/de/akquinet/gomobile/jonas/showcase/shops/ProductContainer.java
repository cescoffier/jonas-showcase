package de.akquinet.gomobile.jonas.showcase.shops;

import de.akquinet.gomobile.jonas.showcase.shops.interfaces.ProductModel;

public class ProductContainer  implements ProductModel{

	String type;
	String id;
	String name;
	double price;

	public ProductContainer(String type){
		this.type=type;
	}

	public String getProductId() {
		return id;
	}

	public String getProductName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setProductId(String id) {
		this.id = id;

	}

	public void setProductName(String name) {
		this.name = name;

	}

	public void setPrice(double price) {
		this.price=price;

	}

	public String getProductType() {
		return type;
	}

}
