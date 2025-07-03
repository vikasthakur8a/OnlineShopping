package com.wipro.productms.controller;

import com.wipro.productms.entity.Product;
import com.wipro.productms.exception.ProductNotFoundException;
import com.wipro.productms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping("/")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        service.addProduct(product);
        return new ResponseEntity<>("Product added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> searchProduct(@PathVariable int productId) throws ProductNotFoundException {
        Product product = service.searchProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable int productId,@RequestBody Product product) throws ProductNotFoundException{
        service.updateProduct(productId, product);
        return new ResponseEntity<>("Product Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) throws ProductNotFoundException{
        service.deleteProduct(productId);
        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }


}