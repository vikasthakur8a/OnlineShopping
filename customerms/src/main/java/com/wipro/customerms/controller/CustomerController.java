package com.wipro.customerms.controller;

import com.wipro.customerms.entity.Customer;
import com.wipro.customerms.exception.CustomerNotFoundException;
import com.wipro.customerms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @PostMapping("/")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
        return new ResponseEntity<>("Customer Added Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) throws CustomerNotFoundException {
        service.deleteCustomer(id);
        return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> searchCustomer(@PathVariable int id) throws CustomerNotFoundException{
        Customer customer = service.searchCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable int id, @RequestBody Customer customer) throws CustomerNotFoundException {
        service.updateCustomer(id, customer);
        return new ResponseEntity<>("Customer Updated Successfully", HttpStatus.OK);
    }
}
