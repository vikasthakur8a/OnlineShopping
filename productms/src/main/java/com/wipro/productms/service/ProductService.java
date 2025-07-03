package com.wipro.productms.service;

import com.wipro.productms.entity.Product;
import com.wipro.productms.exception.ProductNotFoundException;
import com.wipro.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository repo;
	
	@Override
	public void addProduct(Product product) {
		repo.save(product);
	}
	
	@Override
	public Product searchProduct(int productId) throws ProductNotFoundException{
		Product product= repo.findById(productId)
				 .orElseThrow(() -> new ProductNotFoundException("No product found with id : " + productId));
		return product;
		
	}
	@Override
	public void updateProduct(int productId,Product product) throws ProductNotFoundException {
		Product oldProduct = repo.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("No product found with id : " + productId));
		oldProduct.setProductName(product.getProductName());
		oldProduct.setProductDescription(product.getProductDescription());
		oldProduct.setProductPrice(product.getProductPrice());
		oldProduct.setQuantity(product.getQuantity());
		repo.save(oldProduct);
	}
	@Override
	public void deleteProduct(int productId) throws ProductNotFoundException {
		Product product = repo.findById(productId)
				 .orElseThrow(() -> new ProductNotFoundException("No product found with id : " + productId));
	      
        repo.delete(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
}
