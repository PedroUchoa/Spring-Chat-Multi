package com.example.chat_spring.services;

import com.example.chat_spring.dto.chatServerDtos.CreateChatServerDto;
import com.example.chat_spring.dto.chatServerDtos.ReturnChatServerDto;
import com.example.chat_spring.dto.chatServerDtos.UpdateChatServerDto;
import com.example.chat_spring.infra.exceptions.ServerNameDuplicatedException;
import com.example.chat_spring.infra.exceptions.ServerNotFoundException;
import com.example.chat_spring.infra.exceptions.UserDuplicatedInChatException;
import com.example.chat_spring.infra.exceptions.UserNotFoundException;
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
        User user = userRepository.findById(createChatServer.idUser()).orElseThrow(()->new UserNotFoundException(createChatServer.idUser()));
        if(chatServerRepository.findByNameAndIsActiveTrue(createChatServer.name()) != null) throw new ServerNameDuplicatedException(createChatServer.name());
        System.out.println(chatServerRepository.findByNameAndIsActiveTrue(createChatServer.name()));
        ChatServer chatServer = new ChatServer(createChatServer);
        chatServer.getUsers().add(user);
        user.getChatServer().add(chatServer);
        chatServerRepository.save(chatServer);
        userRepository.save(user);
        return new ReturnChatServerDto(chatServer);
    }

    public Page<ReturnChatServerDto> getAllChatServers(Pageable pageable){
        return chatServerRepository.findAllByIsActiveTrue(pageable).map(ReturnChatServerDto::new);
    }

    public ReturnChatServerDto getChatServerById(String id){
        ChatServer chatServer = chatServerRepository.findById(id).orElseThrow(()->new ServerNotFoundException(id));
        return new ReturnChatServerDto(chatServer);
    }

    public ReturnChatServerDto updateChatServer(String id, UpdateChatServerDto updateChatServer){
        ChatServer chatServer = chatServerRepository.findById(id).orElseThrow(()->new ServerNotFoundException(id));
        chatServer.update(updateChatServer);
        chatServerRepository.save(chatServer);
        return new ReturnChatServerDto(chatServer);
    }

    public void deleteChatServer(String id){
        ChatServer chatServer = chatServerRepository.findById(id).orElseThrow(()->new ServerNotFoundException(id));
        chatServer.delete();
        chatServerRepository.save(chatServer);
    }

    public ReturnChatServerDto addUserToChat(String chatId, String userId){
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        ChatServer chatServer = chatServerRepository.findById(chatId).orElseThrow(()->new ServerNotFoundException(chatId));
        if(chatServer.getUsers().contains(user)) throw new UserDuplicatedInChatException(user.getLogin(), chatServer.getName());
        chatServer.getUsers().add(user);
        user.getChatServer().add(chatServer);
        userRepository.save(user);
        chatServerRepository.save(chatServer);
        return new ReturnChatServerDto(chatServer);

    }
    public void removeUserFromChat(String chatId, String userId){
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        ChatServer chatServer = chatServerRepository.findById(chatId).orElseThrow(()->new ServerNotFoundException(chatId));
        chatServer.getUsers().remove(user);
        chatServerRepository.save(chatServer);
    }

    

}
