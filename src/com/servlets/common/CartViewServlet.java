package com.servlets.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;
import com.model.CartItem;
import com.model.ShopCart;
import com.service.CustomerService;
import com.servlets.BaseServlet;

public class CartViewServlet extends BaseServlet {
	private CustomerService customerService = new CustomerService();

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ShopCart cart = (ShopCart) req.getSession().getAttribute("shopcart");//获得购物车

		if (cart == null) {
			addMessage(req, "没有购买任何商品");
		} else {
			customerService.viewCart(cart);
		}
		req.getRequestDispatcher("/common/CartView.jsp").include(req, resp);
	}
}
