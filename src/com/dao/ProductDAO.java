package com.dao;

import java.util.List;

import com.model.Product;

public class ProductDAO {

	private RowParser productParser = new ProductParser();

	public void add(Product product) {
		String sql = "insert into products(proname,prokind,exhost,proprice) values(?,?,?,?)";

		int key = DBUtil.updateWithAutoGen(sql, product.getName(), product
				.getProkind(), product.getExhost(), product.getPrice());
		product.setId(key);
	}

	public Product findByName(String name) {
		String sql = "select proid,proname,prokind,exhost,proprice from products where proname=?";
		return (Product) DBUtil.unique(sql, productParser, name);
	}

	public List<Product> list() {
		String sql = "select proid,proname,prokind,exhost,proprice from products order by proid desc";
		return DBUtil.query(sql, productParser);
	}

	public Product findById(int id) {
		String sql = "select proid,proname,prokind,exhost,proprice from products where proid=?";
		return (Product) DBUtil.unique(sql, productParser, id);
	}

	public void update(Product product) {
		String sql = "update products set proname=?,prokind=?,exhost=?,proprice=? where proid=?";
		DBUtil.update(sql, product.getName(), product.getProkind(), product
				.getExhost(), product.getPrice(), product.getId());

	}
	

}
