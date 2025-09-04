package com.example.chat_spring.dto.UserDtos;

import com.example.chat_spring.dto.chatServerDtos.MinChatServerDto;
import com.example.chat_spring.models.ChatServer;
import com.example.chat_spring.models.User;

import java.util.List;

public record ReturnUserDto(String id, String login, String name, Boolean isActive, List<MinChatServerDto> chatServers) {
    public ReturnUserDto(User user) {
        this(user.getId(), user.getLogin() ,user.getName(), user.getActive(),user.getChatServer().stream().map(MinChatServerDto::new).toList());
    }
}
