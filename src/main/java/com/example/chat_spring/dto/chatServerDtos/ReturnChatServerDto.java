package com.example.chat_spring.dto.chatServerDtos;

import com.example.chat_spring.dto.UserDtos.MinUserDto;
import com.example.chat_spring.dto.chatMessageDtos.MinMessageDto;
import com.example.chat_spring.models.ChatMessage;
import com.example.chat_spring.models.ChatServer;
import com.example.chat_spring.models.User;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public record ReturnChatServerDto(String id, String name, String image, LocalDateTime startDate, LocalDateTime endDate, Boolean isActive, List<MinUserDto> users, List<MinMessageDto> listMessages) {
    public ReturnChatServerDto(ChatServer chatServer) {
        this(
                chatServer.getId(),
                chatServer.getName(),
                chatServer.getImage(),
                chatServer.getStartDate(),
                chatServer.getEndDate(),
                chatServer.getActive(),
                chatServer.getUsers().stream().map(MinUserDto::new).toList(),
                chatServer.getMessages().stream().sorted(Comparator.comparing(ChatMessage::getSendingTime).reversed()).map(MinMessageDto::new).toList());
    }
}
