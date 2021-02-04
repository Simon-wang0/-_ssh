package com.servlets.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CartItem;
import com.model.ShopCart;
import com.servlets.BaseServlet;

public class RemoveItemServlet extends BaseServlet {

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		ShopCart cart = (ShopCart) req.getSession().getAttribute("shopcart");
		if (cart != null) {
			CartItem item = cart.getItems().remove(itemId);//从map中移除条目，直接使用map的方法
			if (item != null) {
				String msg = String.format("已经将%1$s件%2$s从购物车移出", item
						.getAmount(), item.getProduct().getName());
				addMessage(req, msg);
			}
		}
		req.getRequestDispatcher("/common/cartView.action").include(req, resp);
	}

}
