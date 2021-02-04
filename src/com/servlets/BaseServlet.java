package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public abstract class BaseServlet extends HttpServlet {

	protected abstract void execute(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		execute(req, resp);
	}

	protected Object populate(HttpServletRequest request, Object bean) {

		try {
			BeanUtils.populate(bean, request.getParameterMap());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return bean;
	}

	protected void addMessage(HttpServletRequest request, String msg) {
		List<String> msgs = (List<String>) request.getAttribute("messages");
		if (msgs == null) {

			msgs = new ArrayList<String>();
			request.setAttribute("messages", msgs);
		}
		msgs.add(msg);
	}

	protected void addError(HttpServletRequest request, String error) {
		List<String> msgs = (List<String>) request.getAttribute("errors");
		if (msgs == null) {

			msgs = new ArrayList<String>();
			request.setAttribute("errors", msgs);
		}
		msgs.add(error);
	}
}
