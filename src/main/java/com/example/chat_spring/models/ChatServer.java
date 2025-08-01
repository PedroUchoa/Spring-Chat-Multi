package com.example.chat_spring.models;

import com.example.chat_spring.dto.chatServerDtos.CreateChatServerDto;
import com.example.chat_spring.dto.chatServerDtos.UpdateChatServerDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "chatServer")
@Entity(name = "ChatServer")
public class ChatServer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String name;
    private String image;
    @CreationTimestamp
    private LocalDateTime creationDate;
    private LocalDateTime endDate;
    private Boolean isActive;
    @OneToMany(mappedBy = "chatId")
    private List<ChatMessage> messages;
    @ManyToMany(mappedBy = "chatServer")
    @JsonManagedReference
    private List<User> users;

    public ChatServer() {
    }

    public ChatServer(CreateChatServerDto createChatServer) {
        this.name = createChatServer.name();
        this.image = createChatServer.image();
        this.isActive = true;
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void update(UpdateChatServerDto updateChatServer) {
        this.name = updateChatServer.name();
        this.image = updateChatServer.image();
    }

    public void delete() {
        this.isActive = false;
        this.endDate = LocalDateTime.now();
    }
}
