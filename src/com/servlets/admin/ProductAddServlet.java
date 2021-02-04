package com.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ShopException;
import com.model.Product;
import com.service.AdminService;
import com.servlets.BaseServlet;

public class ProductAddServlet extends BaseServlet {
	private AdminService adminSrv = AdminService.getInstance();

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/admin/ProductList.action";
		Product product = (Product) populate(request, new Product());
		try {
			adminSrv.addProduct(product);
			addMessage(request, "商品已经添加到数据库");
		} catch (ShopException e) {
			uri = "/admin/productAdd.jsp";
			addError(request, e.getMessage());
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}

}
