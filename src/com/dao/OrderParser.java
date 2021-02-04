package com.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Product;
import com.model.Order;

public class OrderParser implements RowParser {

	public Object parseRow(ResultSet rs) throws SQLException {
		Order order=new Order();
		order.setId(rs.getInt("orderid"));
		order.setOnDate(rs.getDate("orderdate"));
		order.setAmount(rs.getInt("soamount"));
		order.setTotal(rs.getDouble("prototal"));
		order.setPostAddress(rs.getString("postAddress"));
		order.setPostcard(rs.getString("postcard"));
		order.setTelephone(rs.getString("telephone"));
		order.setContact(rs.getString("contact"));
		order.setUserid(rs.getInt("userid"));
		order.setState(rs.getInt("state"));
		
		return order;
	}

}

