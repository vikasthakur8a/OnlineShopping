package com.wipro.customerms.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Address_Table")
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerAddressId;
	private String doorNo;
	private String streetName;
	private String layout;
	private String city;
	private int pincode;
}
