package com.wipro.shoppingms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int quantity;

}
