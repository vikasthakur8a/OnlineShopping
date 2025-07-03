package com.wipro.productms;

import com.wipro.productms.entity.Product;
import com.wipro.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductCatalogueMicroserviceApplication {

	@Autowired
	private ProductRepository repo;

	@PostConstruct
	public void addProducts(){
		List<Product> products = new ArrayList<>();
		Product product1 = new Product("Android", "Mobile Category", 15000, 35);
		Product product2 = new Product("Iphone", "Mobile Category", 50000, 20);
		Product product3 = new Product("Linux Laptop", "Laptop Category", 40000, 15);
		Product product4 = new Product("Windows Laptop", "Laptop Category", 55000, 25);
		Product product5 = new Product("Macbook", "Laptop Category", 80000, 5);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		repo.saveAll(products);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueMicroserviceApplication.class, args);
	}

}
