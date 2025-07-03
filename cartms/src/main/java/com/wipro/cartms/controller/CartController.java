package com.wipro.cartms.controller;

import com.wipro.cartms.entity.Cart;
import com.wipro.cartms.exception.CartNotFoundException;
import com.wipro.cartms.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/")
    public ResponseEntity<?> addOrder(@RequestBody Cart cart){
        cartService.addCart(cart);
        return new ResponseEntity<>("Cart Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getOrderById(@PathVariable int id) throws CartNotFoundException {
        Cart cart = cartService.searchCart(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) throws CartNotFoundException {
        cartService.deleteCart(id);
        return new ResponseEntity<>("Cart Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable int id, @RequestBody Cart cart) throws CartNotFoundException {
        cartService.updateCart(id, cart);
        return new ResponseEntity<>("Cart Updated Successfully", HttpStatus.OK);
    }

}
