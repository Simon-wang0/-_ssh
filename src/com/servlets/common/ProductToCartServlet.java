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

		ProductDTO productDTO = (ProductDTO) populate(req, new ProductDTO());//取得选购商品id和商品数量

		System.out.println(productDTO.getAmount());
		System.out.println(productDTO.getProductId());
		String msg = String.format("您已将%1$s件%2$s添加到购物车", productDTO.getAmount(),
				productDTO.getProductName());
		
		System.out.println("当前："+msg);
		
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
