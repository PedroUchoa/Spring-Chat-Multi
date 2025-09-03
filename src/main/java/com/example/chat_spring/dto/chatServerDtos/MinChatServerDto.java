package com.example.chat_spring.dto.chatServerDtos;

import com.example.chat_spring.models.ChatServer;

import java.time.LocalDateTime;
import java.util.List;

public record MinChatServerDto(String id, String name, String image, LocalDateTime startDate, LocalDateTime endDate, Boolean isActive) {
    public MinChatServerDto(ChatServer chatServer) {
        this(chatServer.getId(), chatServer.getName(), chatServer.getImage(), chatServer.getStartDate(),chatServer.getEndDate(),chatServer.getActive());
    }
}
