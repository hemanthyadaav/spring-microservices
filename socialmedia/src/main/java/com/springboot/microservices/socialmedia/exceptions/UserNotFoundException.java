package com.springboot.microservices.socialmedia.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    private String message = "User not found for the given ";
    public UserNotFoundException(String message) {
        super(message);
        this.message += message;
    }
}
