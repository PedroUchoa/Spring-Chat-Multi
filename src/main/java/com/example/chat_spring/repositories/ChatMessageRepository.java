package com.example.chat_spring.repositories;

import com.example.chat_spring.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {
    List<ChatMessage> getAllMessagesByChatRoomId(Long chatRoomId);
}
