package com.model;

public class Product {
	private int id;
	private String name;
	private String prokind;
	private String exhost;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProkind() {
		return prokind;
	}

	public void setProkind(String prokind) {
		this.prokind = prokind;
	}

	public String getExhost() {
		return exhost;
	}

	public void setExhost(String exhost) {
		this.exhost = exhost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
