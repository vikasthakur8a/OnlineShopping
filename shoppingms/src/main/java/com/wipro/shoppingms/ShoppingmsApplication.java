package com.wipro.shoppingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShoppingmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingmsApplication.class, args);
	}

}
