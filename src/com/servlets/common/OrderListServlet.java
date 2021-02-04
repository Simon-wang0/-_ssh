package com.servlets.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Order;
import com.model.User;
import com.service.CustomerService;
import com.servlets.BaseServlet;

public class OrderListServlet extends BaseServlet {

	private CustomerService customerService = new CustomerService();
	
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		User user=(User)req.getSession().getAttribute("currentUser");
		List<Order> orderList=customerService.listOrderByUser(user.getId());
		
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("/common/orderList.jsp").include(req, resp);
	}

}
