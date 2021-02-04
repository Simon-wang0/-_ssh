package com.service;

import java.util.List;

import com.dao.ProductDAO;
import com.dao.OrderProductDAO;
import com.dao.OrderDAO;
import com.dao.StorgeDAO;
import com.model.Product;
import com.model.CartItem;
import com.model.Order;
import com.model.OrderProduct;
import com.model.ShopCart;
import com.model.Storage;

public class CustomerService {
	private StorgeDAO storgeDAO = new StorgeDAO();
	private ProductDAO productDAO = new ProductDAO();
	private OrderDAO orderDAO=new OrderDAO();
	private OrderProductDAO oproductDAO=new OrderProductDAO();

	public List<Storage> listStores() {

		return storgeDAO.findProductInStore();
	}

	public Product findProductById(int id) {

		return productDAO.findById(id);
	}

	public void viewCart(ShopCart cart) {//��ȡ��������Ʒ��Ϣ
		for (CartItem m : cart.getItems().values()) {
			if (m.getProduct() == null) {
				Product product = productDAO.findById(m.getProductId());
				m.setProduct(product);
			}

		}
	}
	
	public void generateOrder(Order order,List<OrderProduct> oproducts){
		//����order
		orderDAO.add(order);
		//����orderProduct���б�
		for(OrderProduct oproduct:oproducts){
			oproduct.setOrderid(order.getId());		//ֻ��order������Ժ�Ż����id
			oproductDAO.add(oproduct);
		}
	}
	
	public List<Order> listOrderByUser(int userid){
		return orderDAO.findByUser(userid);
	}
	
	public Order findOrderById(int id) {
		return orderDAO.findById(id);
	}
	
	//�޸ĺ��ύ�������ɵ��ô˷���
	public void updateOrder(Order order){
		orderDAO.update(order);
	}
	
	public void deleteOrder(int orderid){
		//ɾ�����������еĶ����б�orderProduct
		oproductDAO.delete(orderid);
		//ɾ������
		orderDAO.delete(orderid);
	}
	
	public List<OrderProduct> findOrderProductByOrder(int orderid){
		return oproductDAO.findByOrder(orderid);
	}
}
