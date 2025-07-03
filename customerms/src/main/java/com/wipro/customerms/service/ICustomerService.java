package com.wipro.customerms.service;

import com.wipro.customerms.entity.Customer;
import com.wipro.customerms.exception.CustomerNotFoundException;

public interface ICustomerService {

    void addCustomer(Customer customer);

    void deleteCustomer(int id) throws CustomerNotFoundException;

    Customer searchCustomer(int id) throws CustomerNotFoundException;

    void updateCustomer(int id, Customer customer) throws CustomerNotFoundException;

}
