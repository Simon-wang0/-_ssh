package com.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;
import com.service.AdminService;
import com.servlets.BaseServlet;

public class ProductListServlet extends BaseServlet {

	private AdminService adminSrv = AdminService.getInstance();
	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Product> productList = adminSrv.listProduct();//获得商品商品
		//System.out.println("size="+productList.size());
		req.setAttribute("productList", productList);

		req.getRequestDispatcher("/admin/productList.jsp").include(req, resp);
	}
}
