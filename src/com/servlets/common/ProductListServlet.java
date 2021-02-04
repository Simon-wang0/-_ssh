package com.servlets.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Storage;
import com.service.CustomerService;
import com.servlets.BaseServlet;

public class ProductListServlet extends BaseServlet {
	private CustomerService customerSrv = new CustomerService();

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Storage> storages = customerSrv.listStores();
		req.setAttribute("storages", storages);

		req.getRequestDispatcher("/common/productList.jsp").include(req, resp);
	}

}
