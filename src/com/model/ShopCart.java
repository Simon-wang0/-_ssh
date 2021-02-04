package com.model;

import java.util.HashMap;
import java.util.Map;

public class ShopCart {

	private int itemId = 0;
	// private List<CartItem> items = new ArrayList<CartItem>();

	private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();

	public void add(CartItem item) {
		item.setId(itemId++);
		items.put(item.getId(), item);
	}

	public void remove(int itemId) {
		items.remove(itemId);
	}

	public Map<Integer, CartItem> getItems() {
		return items;
	}

	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}

}
