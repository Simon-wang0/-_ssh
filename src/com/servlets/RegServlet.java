package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ShopException;
import com.model.User;
import com.service.UserService;

public class RegServlet extends BaseServlet {
    private UserService loginSrv = new UserService();

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/regView.jsp";
        User user = (User) populate(request, new User());
        request.setAttribute("user", user);
        String confirm = request.getParameter("confirm");
        if (confirm != null && !confirm.equals(user.getPasswd())) {
            url = "/reg.jsp";
        } else {
            try {
                loginSrv.reg(user);
            } catch (ShopException ex) {
                addError(request, ex.getMessage());
                url = "/reg.jsp";
            }
        }
       // request.getRequestDispatcher(url).include(request, response);
        request.getRequestDispatcher(url).forward(request, response);
    }
}
