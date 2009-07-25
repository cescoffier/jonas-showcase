package de.akquinet.gomobile.jonas.showcase.coffee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;

import de.akquinet.gomobile.jonas.showcase.shop.interfaces.BeverageSupplier;

@Component
@Provides
public class CoffeeProvider implements BeverageSupplier {

	private Map<String,CoffeeProduct> coffees;

	public CoffeeProvider(){
		System.out.println("instantiate CoffeeProvider with 3 types of coffee");

		coffees = new HashMap<String, CoffeeProduct>();

		CoffeeProduct coffee1 = new CoffeeProduct("Sumatra", 2.55, "Coffee-Sumatra-0");
		CoffeeProduct coffee2 = new CoffeeProduct("Costa Rica", 2.99, "Coffee-CostaRica-0");
		CoffeeProduct coffee3 = new CoffeeProduct("Columbia", 3.05, "Coffee-Columbia-0");

		coffees.put("Sumatra", coffee1);
		coffees.put("Costa Rica", coffee2);
		coffees.put("Columbia", coffee3);
	}


	public String getBeverageType() {
		return "Coffee";
	}

	public List<String> getAvailableProducts() {
		List<String> list = new ArrayList<String>();
		list.addAll(coffees.keySet());
		return list;
	}

	public double getPrice(String productName) {
		CoffeeProduct coffee = coffees.get(productName);
		if (coffee != null) {
			return coffee.price;
		} else {
			return -1;
		}
	}

	public String getProductId(String p) {
		CoffeeProduct coffee = coffees.get(p);
		if (coffee != null) {
			return coffee.id;
		} else {
			return "unknown";
		}
	}

	private class CoffeeProduct {
		String name;
		double price;
		String id;

		private CoffeeProduct(String name, double price, String id) {
			this.name = name;
			this.price = price;
			this.id = id;
		}
	}
}
