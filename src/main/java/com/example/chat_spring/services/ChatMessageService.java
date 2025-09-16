package com.example.chat_spring.services;

import com.example.chat_spring.dto.UserDtos.MinUserDto;
import com.example.chat_spring.dto.chatMessageDtos.CreateMessageDto;
import com.example.chat_spring.dto.chatMessageDtos.MinMessageDto;
import com.example.chat_spring.dto.chatMessageDtos.ReturnMessageDto;
import com.example.chat_spring.models.ChatMessage;
import com.example.chat_spring.models.ChatServer;
import com.example.chat_spring.models.User;
import com.example.chat_spring.repositories.ChatMessageRepository;
import com.example.chat_spring.repositories.ChatServerRepository;
import com.example.chat_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatMessageService {


    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatServerRepository chatServerRepository;


    public MinMessageDto createMessage(CreateMessageDto createMessageDto, String serverId){
        User user = userRepository.getReferenceById(createMessageDto.senderId());
        ChatServer chatServer = chatServerRepository.getReferenceById(serverId);
        ChatMessage chatMessage = new ChatMessage(createMessageDto.content(),user,chatServer);
        chatMessageRepository.save(chatMessage);
        return new MinMessageDto(chatMessage.getId(),chatMessage.getContent(),chatMessage.getSendingTime(),user.getId(),user.getName());
    }

    public List<ReturnMessageDto> getAllMessagesByChatRoomId(String id){
        return chatMessageRepository.getAllMessagesByChatIdId(id).stream().map(ReturnMessageDto::new).toList();

    }


}
