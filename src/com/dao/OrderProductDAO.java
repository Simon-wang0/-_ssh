package com.dao;

import java.util.List;

import com.model.OrderProduct;

public class OrderProductDAO {

	private RowParser oProductParser = new OrderProductParser();

	public void add(OrderProduct oproduct) {
		String sql = "insert into orderproduct(orderid,proid,orderprice,orderamount) values(?,?,?,?)";

		int key = DBUtil.updateWithAutoGen(sql, oproduct.getOrderid(), oproduct
				.getProductid(), oproduct.getPrice(), oproduct.getAmount());
		oproduct.setId(key);
	}

	public List<OrderProduct> findByOrder(int orderid) {
		String sql = "select soid,orderid,proid,orderprice,orderamount from orderproduct where orderid=?";
		return DBUtil.query(sql, oProductParser, orderid);
	}

	public void delete(int orderid) {
		String sql = "delete from orderproduct where orderid=?";
		DBUtil.update(sql, orderid);
	}

}
