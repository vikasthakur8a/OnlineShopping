package com.wipro.inventoryms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InventoryNotFoundException extends Exception {
    public InventoryNotFoundException(String msg){
        super(msg);
    }
}
