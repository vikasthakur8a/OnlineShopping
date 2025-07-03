package com.wipro.customerms.service;

import com.wipro.customerms.entity.Customer;
import com.wipro.customerms.exception.CustomerNotFoundException;
import com.wipro.customerms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository repo;

    @Override
    public void addCustomer(Customer customer) {
        repo.save(customer);
    }

    @Override
    public void deleteCustomer(int id) throws CustomerNotFoundException {
        Customer customer = searchCustomer(id);
        repo.delete(customer);
    }

    @Override
    public Customer searchCustomer(int id) throws CustomerNotFoundException {
        Customer customer = repo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not exists with id : " + id));
        return customer;
    }

    @Override
    public void updateCustomer(int id, Customer customer) throws CustomerNotFoundException {
        Customer currentCustomer = searchCustomer(id);
        currentCustomer.setCustomerName(customer.getCustomerName());
        currentCustomer.setCustomerEmail(customer.getCustomerEmail());
        currentCustomer.setCustomerBillingAddress(customer.getCustomerBillingAddress());
        currentCustomer.setCustomerShippingAddress(customer.getCustomerShippingAddress());
        repo.save(currentCustomer);
    }
}
