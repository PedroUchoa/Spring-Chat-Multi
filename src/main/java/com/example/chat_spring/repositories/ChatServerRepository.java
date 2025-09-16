package com.example.chat_spring.repositories;

import com.example.chat_spring.models.ChatServer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

public interface ChatServerRepository extends JpaRepository<ChatServer,String> {
    Page<ChatServer> findAllByIsActiveTrue(Pageable pageable);

    ChatServer findByNameAndIsActiveTrue(String name);
}
