package com.dao;

import java.util.List;

import com.model.User;

public class UserDAO {
    public void add(User u) {
        String sql = "insert into users(username,userpasswd,usersex,userage,useraddress,userpostcode,userphone,adm) " + "values(?,?,?,?,?,?,?,?)";
        int key = DBUtil.updateWithAutoGen(sql, u.getName(), u.getPasswd(), u.getSex(), u.getAge(), u.getAddress(), u
                .getPostcode(), u.getPhone(), u.isAdmin());
        u.setId(key);
    }

    public User findById(int id) {
        String sql = "select userid,username,userpasswd,usersex,userage,useraddress,userpostcode,userphone,adm from users where userid=?";
        User u = (User) DBUtil.unique(sql, new UserParser(), id);
        return u;
    }

    public User findByName(String name) {
        String sql = "select userid,username,userpasswd,usersex,userage,useraddress,userpostcode,userphone,adm from users where username=?";
        User u = (User) DBUtil.unique(sql, new UserParser(), name);
        return u;
    }

    public List<User> list() {
        String sql = "select userid,username,userpasswd,usersex,userage,useraddress,userpostcode,userphone,adm from users";
        return DBUtil.query(sql, new UserParser());
    }

    public void delete(int id) {
        DBUtil.update("delete users where userid=?", id);
    }

    public void update(User u) {
        String sql = "update users set userpasswd=?,userage=?,useraddress=?,userpostcode=?,userphone=?,usersex=? where userid=?";
        DBUtil.update(sql, u.getPasswd(), u.getAge(), u.getAddress(), u.getPostcode(), u.getPhone(), u.getSex(), u.getId());
    }

    public void updatePasswd(int id, String passwd) {
        String sql = "update users set userpasswd=? where userid=?";
        DBUtil.update(sql, passwd, id);
    }
}
