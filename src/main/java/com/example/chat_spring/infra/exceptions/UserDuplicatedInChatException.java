package com.example.chat_spring.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Duplicated In This Server")
public class UserDuplicatedInChatException extends RuntimeException{

    public UserDuplicatedInChatException(String userLogin, String serverName){
        super("User with Login: " + userLogin + " Already in the server " + serverName);
    }

}
