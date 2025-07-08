package com.example.chat_spring.repositories;

import com.example.chat_spring.models.ChatServer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatServerRepository extends JpaRepository<ChatServer,String> {
}
