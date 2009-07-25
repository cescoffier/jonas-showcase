package de.akquinet.gomobile.jonas.showcase.shops.interfaces;

import java.util.List;

import javax.ejb.Local;

@Local
public interface Shop {

	public List<ProductModel> getAvailableProducts(String type);
	public List<ProductModel> getAllAvailableProducts();
	public List<String> placeCommand(List<String> ids);

}
