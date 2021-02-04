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

public class PageFilter implements Filter {
    public void destroy() {
        // TODO Auto-generated method stub
    }

    private List<String> exludes = new ArrayList<String>();

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        for (String p : exludes) {
            if (uri.matches(p)) {
                arg2.doFilter(arg0, arg1);
                return;
            }
        }
        uri = uri.substring(contextPath.length());
        
        request.setAttribute("mainPage1", uri);
        
        // if (uri.endsWith(".action")) {
        // arg2.doFilter(arg0, arg1);
        // } 
        request.getRequestDispatcher("/template.jsp").forward(arg0, arg1);
    }

    public void init(FilterConfig arg0) throws ServletException {
        exludes.add(".*logout.action");
    }
}
