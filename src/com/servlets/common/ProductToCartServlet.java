package com.servlets.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ProductDTO;
import com.model.CartItem;
import com.model.ShopCart;
import com.servlets.BaseServlet;

public class ProductToCartServlet extends BaseServlet {

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// int amount = Integer.parseInt(req.getParameter("amount"));
		// int ProductId = Integer.parseInt(req.getParameter("ProductId"));

		ProductDTO productDTO = (ProductDTO) populate(req, new ProductDTO());//ȡ��ѡ����Ʒid����Ʒ����

		System.out.println(productDTO.getAmount());
		System.out.println(productDTO.getProductId());
		String msg = String.format("���ѽ�%1$s��%2$s��ӵ����ﳵ", productDTO.getAmount(),
				productDTO.getProductName());
		
		System.out.println("��ǰ��"+msg);
		
		ShopCart cart = (ShopCart) req.getSession().getAttribute("shopcart");
		if (cart == null) {
			cart = new ShopCart();
			req.getSession().setAttribute("shopcart", cart);
		}
		CartItem item = new CartItem();
		item.setAmount(productDTO.getAmount());
		item.setProductId(productDTO.getProductId());
		cart.add(item);
		addMessage(req, msg);
		req.getRequestDispatcher("/common/productList.action").include(req, resp);
	}

}
