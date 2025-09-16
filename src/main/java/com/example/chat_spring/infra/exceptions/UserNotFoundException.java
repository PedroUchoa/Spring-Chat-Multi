package com.example.chat_spring.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Found In The DataBase")
public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException(String id){
    super("User with id: " + id + " Not Found");
    }

}
