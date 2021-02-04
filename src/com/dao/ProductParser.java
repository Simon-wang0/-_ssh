package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Product;

public class ProductParser implements RowParser {

	public Object parseRow(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("proid"));
		product.setName(rs.getString("proname"));
		product.setExhost(rs.getString("prokind"));
		product.setProkind(rs.getString("exhost"));
		product.setPrice(rs.getDouble("proprice"));
		return product;
	}

}
