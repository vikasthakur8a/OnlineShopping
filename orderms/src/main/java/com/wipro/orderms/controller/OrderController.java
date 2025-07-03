package com.wipro.orderms.controller;

import com.wipro.orderms.entity.Order;
import com.wipro.orderms.exception.OrderNotFoundException;
import com.wipro.orderms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<?> addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return new ResponseEntity<>("Order Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) throws OrderNotFoundException {
        Order order = orderService.searchOrder(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) throws OrderNotFoundException {
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Order Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable int id, @RequestBody Order order) throws OrderNotFoundException{
        orderService.updateOrder(id, order);
        return new ResponseEntity<>("Order Updated Successfully", HttpStatus.OK);
    }

}
