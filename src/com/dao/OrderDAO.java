package com.dao;

import java.util.List;

import com.model.Product;
import com.model.Order;

public class OrderDAO {

	private RowParser orderParser = new OrderParser();

	public void add(Order order) {
		String sql = "insert into `order`(orderdate,soamount,prototal,postAddress,postcard,telephone,contact,userid,state) values(?,?,?,?,?,?,?,?,?)";

		int key = DBUtil.updateWithAutoGen(sql, order.getOnDate(), order
				.getAmount(), order.getTotal(), order.getPostAddress(), order
				.getPostcard(), order.getTelephone(), order.getContact(), order
				.getUserid(), order.getState());
		order.setId(key);
	}

	public List<Order> findByUser(int userid){
		String sql = "select orderid,orderdate,soamount,prototal,postAddress,postcard,telephone,contact,userid,state from `order` where userid=? order by orderdate desc";
		return DBUtil.query(sql, orderParser,userid);
	}
	
	public List<Order> list() {
		String sql = "select orderid,orderdate,soamount,prototal,postAddress,postcard,telephone,contact,userid,state from `order` order by orderdate desc";
		return DBUtil.query(sql, orderParser);
	}

	public Order findById(int id) {
		String sql = "select orderid,orderdate,soamount,prototal,postAddress,postcard,telephone,contact,userid,state from `order` where orderid=?";
		return (Order) DBUtil.unique(sql, orderParser, id);
	}

	public void update(Order order) {
		String sql = "update `order` set orderdate=?,soamount=?,prototal=?,postAddress=?,postcard=?,telephone=?,contact=?,userid=?,state=? where orderid=?";
		DBUtil.update(sql, order.getOnDate(), order.getAmount(), order
				.getTotal(), order.getPostAddress(), order.getPostcard(), order
				.getTelephone(), order.getContact(), order.getUserid(), order
				.getState(),order.getId());

	}
	
	public void delete(int orderid){
		String sql = "delete from `order` where orderid=? and state='1'";
		DBUtil.update(sql, orderid);
	}

}
