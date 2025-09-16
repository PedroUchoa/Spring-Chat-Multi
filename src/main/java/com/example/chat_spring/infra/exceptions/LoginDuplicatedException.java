package com.example.chat_spring.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User Login Already in Use")
public class LoginDuplicatedException extends RuntimeException{

    public LoginDuplicatedException(String login){
        super("Login: " + login + " already in use!");
    }

}
