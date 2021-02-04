package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;

public class UserUpdateServlet extends BaseServlet {
    private UserService userSrv = new UserService();

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) populate(request, new User());
        //System.out.println(user.getId());
        
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        user.setPasswd(currentUser.getPasswd());
        System.out.println(user.getSex());
        userSrv.updateUser(user);
        request.getRequestDispatcher("/common/productList.jsp").forward(request, response);;
    }
}
