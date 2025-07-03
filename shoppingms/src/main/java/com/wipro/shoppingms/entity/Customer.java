package com.wipro.shoppingms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private int customerId;
	private String customerName;
	private String customerEmail;
	private CustomerAddress customerBillingAddress;
	private CustomerAddress customerShippingAddress;

}
