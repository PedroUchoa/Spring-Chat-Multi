package com.example.chat_spring.dto.chatMessageDtos;

import com.example.chat_spring.dto.UserDtos.MinUserDto;
import com.example.chat_spring.models.ChatMessage;
import com.example.chat_spring.models.User;

import java.time.LocalDateTime;

public record ReturnMessageDto(String id, String content, LocalDateTime sendingTime, MinUserDto sender, String chatId) {

    public ReturnMessageDto(ChatMessage chatMessage) {
        this(chatMessage.getId(), chatMessage.getContent(), chatMessage.getSendingTime(), new MinUserDto(chatMessage.getSenderId()) ,chatMessage.getChatId().getId());
    }
}
