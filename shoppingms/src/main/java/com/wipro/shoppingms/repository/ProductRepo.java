package com.wipro.shoppingms.repository;

import com.wipro.shoppingms.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "productms", url = "http://localhost:8082/api/products")
public interface ProductRepo {

    @PostMapping("/")
    void addProduct(@RequestBody Product product);

    @GetMapping("/{productId}")
    Product searchProduct(@PathVariable int productId);

    @PutMapping("/{productId}")
    void updateProduct(@PathVariable int productId,@RequestBody Product product);

    @DeleteMapping("/{productId}")
    void deleteProduct(@PathVariable int productId);

    @GetMapping("/")
    List<Product> getAllProducts();

}
