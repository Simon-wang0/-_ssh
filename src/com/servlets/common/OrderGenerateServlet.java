package com.servlets.common;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CartItem;
import com.model.Order;
import com.model.OrderProduct;
import com.model.ShopCart;
import com.model.User;
import com.service.CustomerService;
import com.servlets.BaseServlet;

public class OrderGenerateServlet extends BaseServlet {

	private CustomerService customerService = new CustomerService();
	
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��order��ֵ
		Order order = (Order) populate(req, new Order());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		order.setOnDate(Date.valueOf(sdf.format(new java.util.Date())));
		
		User user=(User)req.getSession().getAttribute("currentUser");
		order.setUserid(user.getId());
		order.setState(1);
		
		//���orderproduct
		ShopCart cart=(ShopCart)req.getSession().getAttribute("shopcart");
		List<OrderProduct> oproducts=null;
		if(cart!=null){
			oproducts=new ArrayList<OrderProduct>();
			for (CartItem m : cart.getItems().values()) {
				if (m.getProduct() != null) {
					OrderProduct oproduct=new OrderProduct();
					//oproduct.setOrderid(order.getId());			//û�б����Order����ȡ����id
					oproduct.setProductid(m.getProductId());
					oproduct.setPrice(m.getProduct().getPrice());
					oproduct.setAmount(m.getAmount());
					
					oproducts.add(oproduct);
				}
			}
		}
		
		//���ɶ���
		customerService.generateOrder(order, oproducts);
		
		//��չ��ﳵ
		req.getSession().removeAttribute("shopcart");
		
		//ת��
		req.getRequestDispatcher("/common/orderList.action").include(req, resp);
	}

}
