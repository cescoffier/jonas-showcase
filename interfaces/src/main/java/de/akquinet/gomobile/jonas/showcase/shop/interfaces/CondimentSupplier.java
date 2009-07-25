package de.akquinet.gomobile.jonas.showcase.shop.interfaces;

import java.util.List;

public interface CondimentSupplier {
	public String getCondimentType();
	public List<String> getAvailableProducts();
	public String getProductId(String p);
}
