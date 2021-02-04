package com.service;

import com.ShopException;
import com.dao.UserDAO;
import com.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public void reg(User u) {
        User u2 = userDAO.findByName(u.getName());
        if (u2 != null) { throw new ShopException("�û����Ѵ���"); }
        userDAO.add(u);
    }

    public User login(User user) {
        User user2 = userDAO.findByName(user.getName());
        if (user2 == null) { throw new ShopException("�û���������"); }
        if (user.getPasswd() != null && !user.getPasswd().equals(user2.getPasswd())) { throw new ShopException("�û����벻��ȷ"); }
        return user2;
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void changePasswd(int id, String passwd) {
        userDAO.updatePasswd(id, passwd);
    }
}
