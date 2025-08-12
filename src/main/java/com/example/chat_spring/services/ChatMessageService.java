package com.example.chat_spring.services;

import com.example.chat_spring.dto.chatMessageDtos.CreateMessageDto;
import com.example.chat_spring.dto.chatMessageDtos.ReturnMessageDto;
import com.example.chat_spring.models.ChatMessage;
import com.example.chat_spring.models.ChatServer;
import com.example.chat_spring.models.User;
import com.example.chat_spring.repositories.ChatMessageRepository;
import com.example.chat_spring.repositories.ChatServerRepository;
import com.example.chat_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {


    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatServerRepository chatServerRepository;

    public ReturnMessageDto createMessage(CreateMessageDto createMessageDto){
        User user = userRepository.getReferenceById(createMessageDto.senderId());
        ChatServer chatServer = chatServerRepository.getReferenceById(createMessageDto.chatId());
        ChatMessage chatMessage = chatMessageRepository.save(new ChatMessage(createMessageDto.content(),user,chatServer));
        return new ReturnMessageDto(chatMessage);
    }

    public List<ReturnMessageDto> getAllMessagesByChatRoomId(String id){
        return chatMessageRepository.getAllMessagesByChatIdId(id).stream().map(ReturnMessageDto::new).toList();

    }


}
