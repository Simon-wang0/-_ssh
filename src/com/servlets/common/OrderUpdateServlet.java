package com.servlets.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ShopException;
import com.model.Order;
import com.service.CustomerService;
import com.servlets.BaseServlet;

public class OrderUpdateServlet extends BaseServlet {

	private CustomerService customerService = new CustomerService();
	
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Order order = (Order) populate(req, new Order());
		
		try {
			customerService.updateOrder(order);
			addMessage(req, "订单修改成功!");
		} catch (ShopException e) {
			addError(req, e.getMessage());
		}
		req.getRequestDispatcher("/common/orderList.action").forward(req, resp);
	}

}
