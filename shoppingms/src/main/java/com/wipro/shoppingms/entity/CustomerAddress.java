package com.wipro.shoppingms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

	private int customerAddressId;
	private String doorNo;
	private String streetName;
	private String layout;
	private String city;
	private int pincode;
}
