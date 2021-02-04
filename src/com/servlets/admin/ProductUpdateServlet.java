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

public class ProductUpdateServlet extends BaseServlet {

	private AdminService adminSrv = AdminService.getInstance();

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Product product = (Product) populate(req, new Product());
		adminSrv.updateProduct(product);
		req.getRequestDispatcher("/admin/productList.action").include(req, resp);
	}

}
