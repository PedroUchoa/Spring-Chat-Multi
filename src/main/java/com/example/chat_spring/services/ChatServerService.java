package com.example.chat_spring.services;

import com.example.chat_spring.dto.chatServerDtos.CreateChatServerDto;
import com.example.chat_spring.dto.chatServerDtos.ReturnChatServerDto;
import com.example.chat_spring.dto.chatServerDtos.UpdateChatServerDto;
import com.example.chat_spring.models.ChatServer;
import com.example.chat_spring.models.User;
import com.example.chat_spring.repositories.ChatServerRepository;
import com.example.chat_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChatServerService {

    @Autowired
    private ChatServerRepository chatServerRepository;

    @Autowired
    private UserRepository userRepository;

    public ReturnChatServerDto createChatServer(CreateChatServerDto createChatServer){
        ChatServer chatServer = chatServerRepository.save(new ChatServer(createChatServer));
        return new ReturnChatServerDto(chatServer);
    }

    public Page<ReturnChatServerDto> getAllChatServers(Pageable pageable){
        return chatServerRepository.findAllByIsActiveTrue(pageable).map(ReturnChatServerDto::new);
    }

    public ReturnChatServerDto getChatServerById(String id){
        ChatServer chatServer = chatServerRepository.getReferenceById(id);
        return new ReturnChatServerDto(chatServer);
    }

    public ReturnChatServerDto updateChatServer(String id, UpdateChatServerDto updateChatServer){
        ChatServer chatServer = chatServerRepository.getReferenceById(id);
        chatServer.update(updateChatServer);
        chatServerRepository.save(chatServer);
        return new ReturnChatServerDto(chatServer);
    }

    public void deleteChatServer(String id){
        ChatServer chatServer = chatServerRepository.getReferenceById(id);
        chatServer.delete();
        chatServerRepository.save(chatServer);
    }

    public ReturnChatServerDto addUserToChat(String chatId, String userId){
        User user = userRepository.getReferenceById(userId);
        ChatServer chatServer = chatServerRepository.getReferenceById(chatId);

        chatServer.getUsers().add(user);
        chatServerRepository.save(chatServer);
        return new ReturnChatServerDto(chatServer);

    }
    public ReturnChatServerDto removeUserFromChat(String chatId, String userId){
        User user = userRepository.getReferenceById(userId);
        ChatServer chatServer = chatServerRepository.getReferenceById(chatId);

        chatServer.getUsers().remove(user);
        chatServerRepository.save(chatServer);
        return new ReturnChatServerDto(chatServer);
    }

    

}
