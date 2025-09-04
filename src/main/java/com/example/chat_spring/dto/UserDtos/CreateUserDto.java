package com.example.chat_spring.dto.UserDtos;

import com.example.chat_spring.models.User;

public record CreateUserDto(String login, String password , String name) {

    public CreateUserDto(User user){
        this(user.getLogin(),user.getPassword(),user.getName());
    }

}
