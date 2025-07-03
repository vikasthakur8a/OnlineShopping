package com.wipro.shoppingms.repository;

import com.wipro.shoppingms.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "orderms", url = "http://localhost:8085/api/order")
public interface OrderRepo {

    @PostMapping("/")
    void addOrder(@RequestBody Order order);

    @GetMapping("/{id}")
    Order getOrderById(@PathVariable int id);

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable int id);

    @PutMapping("/{id}")
    void updateOrder(@PathVariable int id, @RequestBody Order order);

}
