package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ShopException;
import com.dao.DBUtil;

public class DBFilter implements Filter {
    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2) throws IOException, ServletException {
        try {
            arg2.doFilter(req, resp);
            DBUtil.commit();
        } catch (ShopException ex) {
            DBUtil.rollback();
        } finally {
            DBUtil.closeConnection();
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}
