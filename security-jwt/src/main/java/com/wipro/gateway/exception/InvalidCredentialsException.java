package com.wipro.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidCredentialsException extends Exception{

    public InvalidCredentialsException(String msg){
        super(msg);
    }

}
