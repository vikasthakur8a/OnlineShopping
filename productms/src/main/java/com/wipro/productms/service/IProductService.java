package com.wipro.productms.service;

import com.wipro.productms.entity.Product;
import com.wipro.productms.exception.ProductNotFoundException;

import java.util.List;

public interface IProductService {
	
	void addProduct(Product product);
	
	Product searchProduct(int productId) throws ProductNotFoundException;

	void updateProduct(int productId, Product product) throws ProductNotFoundException;
	
	void deleteProduct(int productId) throws ProductNotFoundException;

	List<Product> getAllProducts();

}
