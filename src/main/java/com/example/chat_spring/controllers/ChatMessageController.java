package com.example.chat_spring.controllers;

import com.example.chat_spring.dto.chatMessageDtos.CreateMessageDto;
import com.example.chat_spring.dto.chatMessageDtos.MinMessageDto;
import com.example.chat_spring.dto.chatMessageDtos.ReturnMessageDto;
import com.example.chat_spring.services.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ChatMessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatMessageService chatMessageService;

    @MessageMapping("/chat/{serverId}/sendMessage")
    @Transactional
    public void createMessage(@DestinationVariable String serverId, CreateMessageDto createMessageDto){
        MinMessageDto message = chatMessageService.createMessage(createMessageDto, serverId);
        messagingTemplate.convertAndSend("/topic/chat/"+serverId,message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ReturnMessageDto>> getAllMessagesByChatRoomId(@PathVariable String chatRoomId){
        List<ReturnMessageDto> returnMessages = chatMessageService.getAllMessagesByChatRoomId(chatRoomId);
        return ResponseEntity.ok(returnMessages);
    }


}
