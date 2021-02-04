package com.servlets.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CartItem;
import com.model.ShopCart;
import com.servlets.BaseServlet;

public class ProductBalanceServlet extends BaseServlet {

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int totAmount=0;		//购物总数量
		double totTotal=0;			//总金额
		
		ShopCart cart = (ShopCart) req.getSession().getAttribute("shopcart");//获得购物车

		if (cart != null) {
			for(Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
				CartItem citem=entry.getValue();
				
				totAmount+=citem.getAmount();
				totTotal+=citem.getProduct().getPrice()*citem.getAmount();
			}
		}
		
		req.setAttribute("totAmount", totAmount);
		req.setAttribute("totTotal", totTotal);
		
		req.getRequestDispatcher("/common/productBalance.jsp").include(req, resp);
	}

}
