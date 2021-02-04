package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Product;
import com.model.OrderProduct;

public class OrderProductParser  implements RowParser {

	private ProductDAO productDAO = new ProductDAO();
	
	public Object parseRow(ResultSet rs) throws SQLException {
		OrderProduct oproduct=new OrderProduct();
		oproduct.setId(rs.getInt("soid"));
		oproduct.setOrderid(rs.getInt("orderid"));
		oproduct.setProductid(rs.getInt("proid"));
		oproduct.setPrice(rs.getDouble("orderprice"));
		oproduct.setAmount(rs.getInt("orderamount"));
		
		Product product=productDAO.findById(rs.getInt("proid"));
		oproduct.setProduct(product);
		
		return oproduct;
	}

}

