package com.example.chat_spring.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Server Name Already in Use")
public class ServerNameDuplicatedException extends RuntimeException{

    public ServerNameDuplicatedException(String name){
        super("Server Name: " + name + " already in use!");
    }

}
