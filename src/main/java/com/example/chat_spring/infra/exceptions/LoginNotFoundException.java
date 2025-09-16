package com.example.chat_spring.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User With This Login Not Found In The DataBase")
public class LoginNotFoundException extends RuntimeException{


    public LoginNotFoundException(String id){
    super("User with Login: " + id + " Not Found");
    }

}
