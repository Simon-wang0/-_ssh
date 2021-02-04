package com.servlets.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ShopException;
import com.model.Order;
import com.service.CustomerService;
import com.servlets.BaseServlet;

public class OrderConfirmServlet extends BaseServlet {
	
	private CustomerService customerService = new CustomerService();
	
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int orderid=Integer.parseInt(req.getParameter("id"));
		
		Order order=customerService.findOrderById(orderid);
		order.setState(2);
		
		try {
			customerService.updateOrder(order);
			addMessage(req, "订单提交成功!");
		} catch (ShopException e) {
			addError(req, e.getMessage());
		}
		req.getRequestDispatcher("/common/orderList.action").forward(req, resp);
		
	}

}
