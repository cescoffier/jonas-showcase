package de.akquinet.gomobile.jonas.showcase.tee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;

import de.akquinet.gomobile.jonas.showcase.shop.interfaces.BeverageSupplier;

@Component
@Provides
public class TeeProvider implements BeverageSupplier {

	private Map<String,TeeProduct> tees;

	public TeeProvider(){

		System.out.println("instantiate TeeProvider with 3 types of tee");

		tees = new HashMap<String, TeeProduct>();

		TeeProduct tee1 = new TeeProduct("Darjeeling", 2.55, "Tee-Darjeeling-0");
		TeeProduct tee2 = new TeeProduct("Ceylan", 1.55, "Tee-Ceylan-0");
		TeeProduct tee3 = new TeeProduct("Assam", 0.99, "Tee-Assam-0");

		tees.put("Darjeeling", tee1);
		tees.put("Ceylan", tee2);
		tees.put("Assam", tee3);
	}


	public String getBeverageType() {
		return "Tee";
	}

	public List<String> getAvailableProducts() {
		List<String> list = new ArrayList<String>();
		list.addAll(tees.keySet());
		return list;
	}

	public double getPrice(String productName) {
		TeeProduct tee = tees.get(productName);
		if (tee != null) {
			return tee.price;
		} else {
			return -1;
		}
	}

	public String getProductId(String p) {
		TeeProduct tee = tees.get(p);
		if (tee != null) {
			return tee.id;
		} else {
			return "unknown";
		}
	}

	private class TeeProduct {
		String name;
		double price;
		String id;

		private TeeProduct(String name, double price, String id) {
			this.name = name;
			this.price = price;
			this.id = id;
		}
	}
}
