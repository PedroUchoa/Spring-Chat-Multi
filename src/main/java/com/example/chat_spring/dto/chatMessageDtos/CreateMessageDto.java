package com.example.chat_spring.dto.chatMessageDtos;

public record CreateMessageDto(String content, Long senderId, Long chatId) {
}
