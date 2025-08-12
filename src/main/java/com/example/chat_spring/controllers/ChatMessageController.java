package com.example.chat_spring.controllers;

import com.example.chat_spring.dto.chatMessageDtos.CreateMessageDto;
import com.example.chat_spring.dto.chatMessageDtos.ReturnMessageDto;
import com.example.chat_spring.services.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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

    @MessageMapping("/chat.sendMessage")
    public ResponseEntity<ReturnMessageDto> createMessage(@Payload CreateMessageDto createMessageDto){
        ReturnMessageDto returnMessageDto = chatMessageService.createMessage(createMessageDto);
        messagingTemplate.convertAndSend("/topic/chatroom."+createMessageDto.chatId(),createMessageDto);
        return ResponseEntity.ok(returnMessageDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ReturnMessageDto>> getAllMessagesByChatRoomId(@PathVariable String chatRoomId){
        List<ReturnMessageDto> returnMessages = chatMessageService.getAllMessagesByChatRoomId(chatRoomId);
        return ResponseEntity.ok(returnMessages);
    }


}
