package com.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		uri = uri.substring(ctxPath.length());
		User user = (User) request.getSession().getAttribute("currentUser");
		if (user == null
				&& (uri.startsWith("/admin") || uri.startsWith("/common"))) {
			//request.getRequestDispatcher("/login.jsp").forward(req, resp);
			 response.sendRedirect(ctxPath + "/login.jsp");
		} else if (user != null && !user.isAdmin() && uri.startsWith("/admin")) {
			//request.getRequestDispatcher("/login.jsp").forward(req, resp);
			 response.sendRedirect(ctxPath + "/login.jsp");

		} else {
			chain.doFilter(req, resp);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
