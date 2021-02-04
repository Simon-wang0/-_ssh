package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;

public class ChangePasswordServlet extends BaseServlet {
    private UserService userSrv = new UserService();

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPasswd = request.getParameter("oldPasswd");
        String passwd = request.getParameter("passwd");
        String confirm = request.getParameter("confirm");
        String uri = "/common/productList.jsp";
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (!oldPasswd.equals(currentUser.getPasswd())) {
            uri = "/common/passwd.jsp";
            addError(request, "原密码错误");
        } else if (!passwd.equals(confirm)) {
            uri = "/common/passwd.jsp";
            addError(request, "新密码不一致");
        } else {
            userSrv.changePasswd(currentUser.getId(), passwd);
        }
    }
}
