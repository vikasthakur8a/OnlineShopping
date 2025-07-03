package com.wipro.shoppingms.repository;

import com.wipro.shoppingms.entity.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cartms", url = "http://localhost:8084/api/cart")
public interface CartRepo {

    @PostMapping("/")
    void addOrder(@RequestBody Cart cart);

    @GetMapping("/{id}")
    Cart getOrderById(@PathVariable int id);

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable int id);

    @PutMapping("/{id}")
    void updateOrder(@PathVariable int id, @RequestBody Cart cart);

}
