package de.akquinet.gomobile.jonas.showcase.shops.interfaces;

public interface ProductModel {

	public String getProductType();
	public String getProductId();
	public void setProductId(String deviceId);
	public String getProductName();
	public void setProductName(String deviceName);

	public double getPrice();
	public void setPrice(double price);

}
