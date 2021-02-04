package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;

public class UserParser implements RowParser {
    public Object parseRow(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("userid"));
        u.setAge(rs.getInt("userage"));
        u.setName(rs.getString("username"));
        u.setAddress(rs.getString("useraddress"));
        u.setPasswd(rs.getString("userpasswd"));
        u.setPhone(rs.getString("userphone"));
        u.setPostcode(rs.getString("userpostcode"));
        u.setSex(rs.getString("usersex"));
        u.setAdmin(rs.getBoolean("adm"));
        return u;
    }
}
