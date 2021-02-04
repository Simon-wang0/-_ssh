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
			CartItem item = cart.getItems().remove(itemId);//��map���Ƴ���Ŀ��ֱ��ʹ��map�ķ���
			if (item != null) {
				String msg = String.format("�Ѿ���%1$s��%2$s�ӹ��ﳵ�Ƴ�", item
						.getAmount(), item.getProduct().getName());
				addMessage(req, msg);
			}
		}
		req.getRequestDispatcher("/common/cartView.action").include(req, resp);
	}

}
