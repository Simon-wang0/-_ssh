package com.servlets.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Order;
import com.model.OrderProduct;
import com.service.CustomerService;
import com.servlets.BaseServlet;

public class OrderViewServlet extends BaseServlet {

	private CustomerService customerService = new CustomerService();

	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int orderid=Integer.parseInt(req.getParameter("id"));
		
		Order order=customerService.findOrderById(orderid);
		List<OrderProduct> oproducts= customerService.findOrderProductByOrder(orderid);
		
		req.setAttribute("orderView", order);
		req.setAttribute("orderProducts", oproducts);
		
		if(req.getParameter("isupdate")!=null && req.getParameter("isupdate").equals("yes")){
			req.setAttribute("isupdate", "yes");
		}
		
		req.getRequestDispatcher("/common/orderView.jsp").forward(req, resp);
		
	}

}
