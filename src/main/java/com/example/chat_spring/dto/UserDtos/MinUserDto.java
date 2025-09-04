package com.example.chat_spring.dto.UserDtos;

import com.example.chat_spring.models.User;

public record MinUserDto(String id, String login ,String name, Boolean isActive) {

    public MinUserDto(User user){
        this(user.getId(), user.getLogin() ,user.getName(),user.getActive());
    }

}
