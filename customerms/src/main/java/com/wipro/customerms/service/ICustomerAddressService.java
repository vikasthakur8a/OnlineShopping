package com.wipro.customerms.service;

import com.wipro.customerms.entity.CustomerAddress;
import com.wipro.customerms.exception.AddressNotFoundException;

public interface ICustomerAddressService {

    void addAddress(CustomerAddress address);

    void deleteAddress(int id) throws AddressNotFoundException;

    CustomerAddress searchAddress(int id) throws AddressNotFoundException;

    void updateAddress(int id, CustomerAddress address) throws AddressNotFoundException;

}
