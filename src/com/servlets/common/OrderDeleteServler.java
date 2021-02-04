package com.servlets.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ShopException;
import com.service.CustomerService;
import com.servlets.BaseServlet;

public class OrderDeleteServler extends BaseServlet {

	private CustomerService customerService = new CustomerService();
	
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int orderid=Integer.parseInt(req.getParameter("id"));
		
		try {
			customerService.deleteOrder(orderid);
			addMessage(req, "¶©µ¥É¾³ý³É¹¦!");
		} catch (ShopException e) {
			addMessage(req, "¶©µ¥É¾³ýÊ§°Ü!");
			addError(req, e.getMessage());
		}
		req.getRequestDispatcher("/common/orderList.action").forward(req, resp);
	}

}
