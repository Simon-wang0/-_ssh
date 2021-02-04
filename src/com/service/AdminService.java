package com.service;

import java.util.List;

import com.ShopException;
import com.dao.ProductDAO;
import com.dao.StorgeDAO;
import com.model.Product;
import com.model.Storage;

public class AdminService {
	private ProductDAO productDAO = new ProductDAO();
	private StorgeDAO storgeDAO = new StorgeDAO();

	// 单例模式

	private AdminService() {
	}

	private static AdminService adminService;

	public static AdminService getInstance() {
		if (adminService == null) {
			adminService = new AdminService();
		}
		return adminService;
	}

	public void addProduct(Product product) {
		if (productDAO.findByName(product.getName()) != null)
			throw new ShopException("商品已存在");

		productDAO.add(product);

	}

	public List<Product> listProduct() {
		List<Product> list = productDAO.list();
		System.out.println(list.size());
		return list;

	}

	public Product getProduct(int id) {

		return productDAO.findById(id);
	}

	public void updateProduct(Product product) {
		productDAO.update(product);

	}

	public void addStorage(Storage s) {
		Storage s2 = storgeDAO.findByProductId(s.getProductId());
		if (s2 == null)
			storgeDAO.add(s);
		else {
			s2.setAmount(s2.getAmount() + s.getAmount());
			storgeDAO.update(s2);
		}
	}

	public List<Storage> listStorage() {

		List<Storage> list = storgeDAO.list();
		for (Storage s : list) {
			s.setProduct(productDAO.findById(s.getProductId()));
		}
		return list;
	}

}
