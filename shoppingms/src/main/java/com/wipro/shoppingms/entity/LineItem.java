package com.wipro.shoppingms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItem {
    private int itemId;
    private int productId;
    private String productName;
    private int quantity;
    private double price;
}