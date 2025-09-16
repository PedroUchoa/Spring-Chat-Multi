package com.example.chat_spring.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Server Not Found In The DataBase")
public class ServerNotFoundException extends RuntimeException{

    public ServerNotFoundException(String id){
        super("Server with id: " + id + " Not Found");
    }

}
