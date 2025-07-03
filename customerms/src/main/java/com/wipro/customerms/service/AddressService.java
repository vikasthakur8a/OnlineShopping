package com.wipro.customerms.service;

import com.wipro.customerms.entity.CustomerAddress;
import com.wipro.customerms.exception.AddressNotFoundException;
import com.wipro.customerms.repository.CustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements ICustomerAddressService {

    @Autowired
    private CustomerAddressRepository repo;

    @Override
    public void addAddress(CustomerAddress address) {
        repo.save(address);
    }

    @Override
    public void deleteAddress(int id) throws AddressNotFoundException {
        CustomerAddress address = searchAddress(id);
        repo.delete(address);
    }

    @Override
    public CustomerAddress searchAddress(int id) throws AddressNotFoundException {
        CustomerAddress address = repo.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address not found with id : " + id));
        return address;
    }

    @Override
    public void updateAddress(int id, CustomerAddress address) throws AddressNotFoundException {
        CustomerAddress currentAddress = searchAddress(id);
        currentAddress.setDoorNo(address.getDoorNo());
        currentAddress.setStreetName(address.getStreetName());
        currentAddress.setLayout(address.getLayout());
        currentAddress.setCity(address.getCity());
        currentAddress.setPincode(address.getPincode());
        repo.save(currentAddress);
    }
}
