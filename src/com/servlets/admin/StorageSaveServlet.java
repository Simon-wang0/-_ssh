package com.servlets.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ShopException;
import com.model.Storage;
import com.service.AdminService;
import com.servlets.BaseServlet;

public class StorageSaveServlet extends BaseServlet {

	private AdminService adminSrv = AdminService.getInstance();

	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uri = "/admin/storageList.action";
		Storage s = (Storage) populate(req, new Storage());
		try {
			adminSrv.addStorage(s);
			addMessage(req, "Ìí¼Ó¿â´æ³É¹¦");
		} catch (ShopException e) {
			addError(req, e.getMessage());
			uri = "/admin/storageAdd.action";
		}
		req.getRequestDispatcher(uri).forward(req, resp);
	}

}
