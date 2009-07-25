package de.akquinet.gomobile.jonas.showcase.shops;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.ow2.easybeans.osgi.annotation.Multiplicity;
import org.ow2.easybeans.osgi.annotation.OSGiResource;

import de.akquinet.gomobile.jonas.showcase.shop.interfaces.BeverageSupplier;
import de.akquinet.gomobile.jonas.showcase.shop.interfaces.CondimentSupplier;
import de.akquinet.gomobile.jonas.showcase.shops.interfaces.ProductModel;
import de.akquinet.gomobile.jonas.showcase.shops.interfaces.Shop;


@Stateless(name="CoffeeShopBean")
public class CoffeeShopBean implements Shop {

	@OSGiResource
	private BundleContext bundleContext = null;

	@OSGiResource(multiplicity=Multiplicity.MULTIPLE, type=BeverageSupplier.class)
	private List<BeverageSupplier> bevSupps;

	public List<ProductModel> getAvailableProducts(String type) {
		List<ProductModel> menu = new ArrayList<ProductModel>();

		if (type.equals("beverages")) {
			menu.addAll(getBeverages());
		} else if (type.equals("condiments")) {
			menu.addAll(getCondiments());
		}

		return menu;
	}

	private List<ProductModel> getBeverages() {

		List<ProductModel> menu = new ArrayList<ProductModel>();

		// Get beverages from the service injection.
		if (bevSupps!=null) { // Must check because it can be null (no supplier)
			for (BeverageSupplier supplier : bevSupps) {
				List<String> products = supplier.getAvailableProducts();
				for (String p : products) {
					ProductModel model = new ProductContainer(supplier.getBeverageType());
					model.setProductId(supplier.getProductId(p));
					model.setProductName(p);
					model.setPrice(supplier.getPrice(p));
					menu.add(model);
				}
			}
		}

		return menu;
	}

	private List<ProductModel> getCondiments() {

		List<ProductModel> menu = new ArrayList<ProductModel>();

		// Get condiment with the bundle context
		ServiceReference[] refs = null;
		try {
			refs = bundleContext.getServiceReferences(CondimentSupplier.class.getName(), null);
		} catch (InvalidSyntaxException e) {
			// Cannot happen.
		}

		if (refs != null) { // Returns null if no providers are available.
			for (int i = 0; i < refs.length; i++) {
				CondimentSupplier supplier = (CondimentSupplier) bundleContext.getService(refs[i]);
				List<String> products = supplier.getAvailableProducts();
				for (String p : products) {
					ProductModel model = new ProductContainer(supplier.getCondimentType());
					model.setProductId(supplier.getProductId(p));
					model.setProductName(p);
					model.setPrice(0); // Condiments are free.
					menu.add(model);
				}
			}
		}

		return menu;
	}

	public List<ProductModel> getAllAvailableProducts() {
		List<ProductModel> menu = new ArrayList<ProductModel>();

		menu.addAll(getBeverages());
		menu.addAll(getCondiments());

		return menu;
	}

	private boolean isAvailable(String id, List<ProductModel> list) {
		for (ProductModel product : list) {
			if (product.getProductId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public List<String> placeCommand(List<String> ids) {
		System.out.println("The command is " + ids);
		List<String> missing = new ArrayList<String>();
		List<ProductModel> available = getAllAvailableProducts();

		for (String id : ids) {
			if (! isAvailable(id, available)) {
				missing.add(id);
			}
		}
		System.out.println("Missing " + missing);
		return missing;
	}

}
