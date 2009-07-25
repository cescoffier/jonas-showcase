package de.akquinet.gomobile.jonas.showcase.milk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;

import de.akquinet.gomobile.jonas.showcase.shop.interfaces.CondimentSupplier;

@Local(CondimentSupplier.class)
@Stateless(mappedName="MilkProvider")
public class MilkProvider implements CondimentSupplier {

	private Map<String,MilkProduct> milks;

	public MilkProvider() {
		System.out.println("instantiate MilkProvider with 2 types of milk");

		milks = new HashMap<String, MilkProduct>();

		MilkProduct milk1 = new MilkProduct("Skim", "Milk-Skim-0");
		MilkProduct milk2 = new MilkProduct("Regular", "Milk-Regular-0");

		milks.put("Skim Milk", milk1);
		milks.put("Milk", milk2);
	}


	public List<String> getAvailableProducts() {
		List<String> list = new ArrayList<String>();
		list.addAll(milks.keySet());
		return list;
	}

	public String getProductId(String p) {
		MilkProduct milk = milks.get(p);
		if (milk != null) {
			return milk.id;
		} else {
			return "unknown";
		}
	}

	public String getCondimentType() {
		return "Milk";
	}


}
