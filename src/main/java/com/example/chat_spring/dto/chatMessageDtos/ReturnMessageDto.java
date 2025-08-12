package com.example.chat_spring.dto.chatMessageDtos;

import com.example.chat_spring.models.ChatMessage;
import com.example.chat_spring.models.User;

import java.time.LocalDateTime;

public record ReturnMessageDto(String id, String content, LocalDateTime sendingTime, User sender, String chatId) {

    public ReturnMessageDto(ChatMessage chatMessage) {
        this(chatMessage.getId(), chatMessage.getContent(), chatMessage.getSendingTime(), chatMessage.getSenderId(),chatMessage.getChatId().getId());
    }
}
