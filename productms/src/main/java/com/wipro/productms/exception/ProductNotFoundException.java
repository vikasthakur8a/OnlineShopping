package com.wipro.productms.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception{

	 public ProductNotFoundException(String msg){
	        super(msg);
	    }

}
