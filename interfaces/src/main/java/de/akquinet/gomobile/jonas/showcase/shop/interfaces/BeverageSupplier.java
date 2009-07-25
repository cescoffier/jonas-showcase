package de.akquinet.gomobile.jonas.showcase.shop.interfaces;

import java.util.List;

public interface BeverageSupplier {
	public String getBeverageType();
	public List<String> getAvailableProducts();
	public double getPrice(String productName);
	public String getProductId(String p);
}
