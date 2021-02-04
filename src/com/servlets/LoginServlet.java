package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ShopException;
import com.model.User;
import com.service.UserService;

public class LoginServlet extends BaseServlet {
	private UserService loginSrv = new UserService();

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/common/productList.action";
		//String aaa=request.getParameter("role");
		User user = (User) populate(request, new User());

		 
		boolean isAdmin = "admin".equals(request.getParameter("role"));
		request.setAttribute("user", user);
		try {
			user = loginSrv.login(user);//��ȡ�����ġ���ȷ���û���Ϣ
			if (isAdmin && !user.isAdmin()) {
				throw new ShopException("��Ȩ��Ϊ����Ա��½");
			}
			if (isAdmin) {
				uri = "/admin/productList.action";
			}
			request.getSession().setAttribute("currentUser", user);
		} catch (ShopException e) {
			e.printStackTrace();
			uri = "/login.jsp";
			addError(request, e.getMessage());
		}	
		request.getRequestDispatcher(uri).include(request, response);
	}
}
