package de.akquinet.gomobile.jonas.showcase.sugar;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import de.akquinet.gomobile.jonas.showcase.shop.interfaces.CondimentSupplier;

@Local(CondimentSupplier.class)
@Stateless(mappedName="SugarProvider")
public class SugarProvider implements CondimentSupplier {


	public List<String> getAvailableProducts() {
		List<String> list = new ArrayList<String>();
		list.add("sugar");
		return list;
	}

	public String getProductId(String p) {
		return "sugar-0";
	}

	public String getCondimentType() {
		return "Sugar";
	}


}
