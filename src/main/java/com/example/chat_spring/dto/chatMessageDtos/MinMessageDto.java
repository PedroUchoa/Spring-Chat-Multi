package com.example.chat_spring.dto.chatMessageDtos;

import com.example.chat_spring.models.ChatMessage;

import java.time.LocalDateTime;

public record MinMessageDto(String id, String content, LocalDateTime sendingTime, String senderId, String senderName) {

    public MinMessageDto(ChatMessage chatMessage){
        this(chatMessage.getId(), chatMessage.getContent(), chatMessage.getSendingTime(), chatMessage.getSenderId().getId(),chatMessage.getSenderId().getName());
    }

}
