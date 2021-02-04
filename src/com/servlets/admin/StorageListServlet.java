package com.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Storage;
import com.service.AdminService;
import com.servlets.BaseServlet;

public class StorageListServlet extends BaseServlet {

	private AdminService adminSrv = AdminService.getInstance();

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Storage> storageList = adminSrv.listStorage();
		req.setAttribute("storageList", storageList);
		System.out.println("aaaaaaaaaa" + storageList.size());
		req.getRequestDispatcher("/admin/StorgeList.jsp").include(req, resp);
	}

}
