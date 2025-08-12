package com.example.chat_spring.controllers;

import com.example.chat_spring.dto.chatServerDtos.CreateChatServerDto;
import com.example.chat_spring.dto.chatServerDtos.ReturnChatServerDto;
import com.example.chat_spring.dto.chatServerDtos.UpdateChatServerDto;
import com.example.chat_spring.services.ChatServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/chatServer")
public class ChatServerController {

    @Autowired
    private ChatServerService chatServerService;

    @PostMapping
    @Transactional
    public ResponseEntity<ReturnChatServerDto> createChatServer(@RequestBody CreateChatServerDto createChatServerDto, UriComponentsBuilder uriComponentsBuilder){
        ReturnChatServerDto returnChatServerDto = chatServerService.createChatServer(createChatServerDto);
        URI location = uriComponentsBuilder.path("/id")
                .buildAndExpand(returnChatServerDto.id())
                .toUri();
        return ResponseEntity.created(location).body(returnChatServerDto);
    }

    @PostMapping("/{id}/add/{userId}")
    @Transactional
    public ResponseEntity<ReturnChatServerDto> addUserToChat(@PathVariable String id, @PathVariable String userId){
        ReturnChatServerDto returnChatServerDto = chatServerService.addUserToChat(id,userId);
        return ResponseEntity.ok(returnChatServerDto);

    }

    @GetMapping
    public ResponseEntity<Page<ReturnChatServerDto>> getAllChatServers(@PageableDefault(sort = {"id"})Pageable pageable){
        Page<ReturnChatServerDto> chatServerDtos = chatServerService.getAllChatServers(pageable);
        return ResponseEntity.ok(chatServerDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnChatServerDto> getChatServerById(@PathVariable String id){
        ReturnChatServerDto chatServerDto = chatServerService.getChatServerById(id);
        return ResponseEntity.ok(chatServerDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ReturnChatServerDto> updateChatServer(@PathVariable String id, @RequestBody UpdateChatServerDto updateChatServerDto){
        ReturnChatServerDto returnChatServer = chatServerService.updateChatServer(id,updateChatServerDto);
        return ResponseEntity.ok(returnChatServer);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteChatServer(@PathVariable String id){
        chatServerService.deleteChatServer(id);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/remove/{userId}")
    @Transactional
    public ResponseEntity<Void> removeUserFromChat(@PathVariable String id, @PathVariable String userId){
        chatServerService.removeUserFromChat(id,userId);
        return ResponseEntity.noContent().build();
    }




}
