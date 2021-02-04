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
			addMessage(req, "����ɾ���ɹ�!");
		} catch (ShopException e) {
			addMessage(req, "����ɾ��ʧ��!");
			addError(req, e.getMessage());
		}
		req.getRequestDispatcher("/common/orderList.action").forward(req, resp);
	}

}
