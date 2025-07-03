package com.wipro.customerms.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer_Table")
public class Customer {
	
	@Id
	private int customerId;

	private String customerName;

	private String customerEmail;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_address_id", referencedColumnName = "customerAddressId")
	private CustomerAddress customerBillingAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_address_id", referencedColumnName = "customerAddressId")
	private CustomerAddress customerShippingAddress;

}
