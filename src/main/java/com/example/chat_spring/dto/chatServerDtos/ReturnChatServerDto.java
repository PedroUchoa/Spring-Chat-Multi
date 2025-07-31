package com.example.chat_spring.dto.chatServerDtos;

import com.example.chat_spring.models.ChatMessage;
import com.example.chat_spring.models.ChatServer;
import com.example.chat_spring.models.User;

import java.time.LocalDateTime;
import java.util.List;

public record ReturnChatServerDto(Long id, String name, String image, LocalDateTime creationDate, LocalDateTime endDate, Boolean isActive, List<User> users, List<ChatMessage> listMessages) {
    public ReturnChatServerDto(ChatServer chatServer) {
        this(chatServer.getId(), chatServer.getName(), chatServer.getImage(), chatServer.getCreationDate(),chatServer.getEndDate(),chatServer.getActive(),chatServer.getUsers(), chatServer.getMessages());
    }
}
