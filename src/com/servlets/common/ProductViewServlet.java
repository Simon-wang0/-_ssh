package com.servlets.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;
import com.service.CustomerService;
import com.servlets.BaseServlet;

public class ProductViewServlet extends BaseServlet {
	private CustomerService customerService = new CustomerService();

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Product product = customerService.findProductById(id);
		req.setAttribute("product", product);
		req.getRequestDispatcher("/common/productView.jsp").forward(req, resp);
	}
}
