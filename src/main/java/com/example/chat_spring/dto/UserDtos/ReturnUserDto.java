package com.example.chat_spring.dto.UserDtos;

import com.example.chat_spring.models.ChatServer;
import com.example.chat_spring.models.User;

import java.util.List;

public record ReturnUserDto(Long id, String name, Boolean isActive, List<ChatServer> chatServers) {
    public ReturnUserDto(User user) {
        this(user.getId(), user.getName(), user.getActive(),user.getChatServer());
    }
}
