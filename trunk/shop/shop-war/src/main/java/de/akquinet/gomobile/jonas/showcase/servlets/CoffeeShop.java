package de.akquinet.gomobile.jonas.showcase.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import de.akquinet.gomobile.jonas.showcase.shops.interfaces.ProductModel;
import de.akquinet.gomobile.jonas.showcase.shops.interfaces.Shop;

public class CoffeeShop extends HttpServlet {

	/**
	 * UUID.
	 */
	private static final long serialVersionUID = 7137122460787722027L;

	@EJB(name="CoffeeShopBean")
	private Shop shop;

	/**
	 * Id => Name mapping.
	 */
	private Map<String,String> products = new HashMap<String, String>();

	/**
	 * doGet is used to retrieve the available beverages and add-ons.
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("JSON CoffeeShop Servlet called : " + req.getParameter("type"));
		buildMapping();
		// Has to return JSON structure.
		if (req.getParameter("type") != null  && req.getParameter("type").equals("beverages")) {
			JSONObject json = new JSONObject();
			json.put("identifier", "'value'");
			json.put("label", "'name'");
			json.put("items", fillBeveragesList());
			System.out.println(json);
			PrintWriter out = resp.getWriter();
			out.println(json);
			return;
		}

		if (req.getParameter("type") != null  && req.getParameter("type").equals("condiments")) {
			JSONObject json = new JSONObject();
			json.put("identifier", "'value'");
			json.put("label", "'name'");
			json.put("items", fillCondimentsList());
			System.out.println(json);
			PrintWriter out = resp.getWriter();
			out.println(json);
			return;
		}

	}

	/**
	 * doPost is used to place an order.
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String message = "";
		boolean success = false;


		String c = req.getParameter("command");
		if (c == null) {
			return;
		}
		JSONObject comm = (JSONObject) JSONSerializer.toJSON(c);

		String beverage = comm.getString("beverage");
		JSONArray condiments = comm.getJSONArray("addon");

		if (beverage.length() != 0 || ! condiments.isEmpty()) {
			// process command.
			List<String> command = new ArrayList<String>();
			if (beverage.length() != 0) {
				command.add(beverage);
			}

			if (condiments != null) {
				for (int i = 0; i < condiments.size(); i++) {
					command.add(condiments.getString(i));
				}
			}

			List<String> missing = shop.placeCommand(command);
			System.out.println("Empty ? " + missing.size());
			if (missing.isEmpty()) {
				message = "Your command is ready.";
				success = true;
			} else {
				List<String> miss = new ArrayList<String>();
				for (String id : missing) {
					miss.add(products.get(id));
				}
				message = "Sorry, some products are unavailable : " + miss;
				success = false;
			}

			JSONObject json = new JSONObject();
			json.put("message", message);
			json.put("success", success);

			System.out.println("Result : " + json);

			PrintWriter out = resp.getWriter();
			out.println(json);
		}
	}

	private List<Map<String, String>> fillBeveragesList(){
		List<Map<String, String>> beverages = new ArrayList<Map<String,String>>();
		List<ProductModel> products = shop.getAvailableProducts("beverages");
		for (ProductModel p : products) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", p.getProductName() + " (" + p.getProductType() + ")");
			map.put("value", p.getProductId());
			beverages.add(map);
		}
		return beverages;
	}

	private List<Map<String, String>> fillCondimentsList(){
		List<Map<String, String>> beverages = new ArrayList<Map<String,String>>();
		List<ProductModel> products = shop.getAvailableProducts("condiments");
		for (ProductModel p : products) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", p.getProductName());
			map.put("value", p.getProductId());
			beverages.add(map);
		}
		return beverages;
	}

	private void buildMapping() {
		List<ProductModel> products = shop.getAllAvailableProducts();
		for (ProductModel product : products) {
			this.products.put(product.getProductId(), product.getProductName() + " (" + product.getProductType() + ")");
		}
	}


}
