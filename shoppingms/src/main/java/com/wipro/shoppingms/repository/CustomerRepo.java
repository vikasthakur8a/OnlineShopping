package com.wipro.shoppingms.repository;

import com.wipro.shoppingms.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "customerms", url = "http://localhost:8081/api/customer")
public interface CustomerRepo {

    @PostMapping("/")
    void addCustomer(@RequestBody Customer customer);

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable int id);

    @GetMapping("/{id}")
    Customer searchCustomer(@PathVariable int id);

    @PutMapping("/{id}")
    void updateCustomer(@PathVariable int id, @RequestBody Customer customer);

}
