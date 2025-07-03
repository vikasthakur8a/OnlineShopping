package com.wipro.customerms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.customerms.entity.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {
	
}