package com.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;
import com.service.AdminService;
import com.servlets.BaseServlet;

public class ProductViewServlet extends BaseServlet {
	private AdminService adminSrv = AdminService.getInstance();

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Product product = adminSrv.getProduct(id);
		req.setAttribute("product", product);
		req.getRequestDispatcher("/admin/productView.jsp").forward(req, resp);
	}
}
