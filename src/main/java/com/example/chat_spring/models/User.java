package com.example.chat_spring.models;

import com.example.chat_spring.dto.UserDtos.CreateUserDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name="user")
@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @CreationTimestamp
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isActive;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_chat",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_server_id"))
    @JsonIgnoreProperties("users")
    private List<ChatServer> chatServer = new ArrayList<>();

    @OneToMany(mappedBy = "senderId",fetch = FetchType.EAGER)
    @JsonBackReference
    private List<ChatMessage> chatMessages = new ArrayList<>();

    public User() {}

    public User(List<ChatServer> chatServer, LocalDateTime endDate, Boolean isActive, LocalDateTime startDate, String name, String id, List<ChatMessage> chatMessage) {
        this.chatServer = chatServer;
        this.endDate = endDate;
        this.isActive = isActive;
        this.startDate = startDate;
        this.name = name;
        this.id = id;
        this.chatMessages = chatMessage;
    }

    public User(CreateUserDto userDto) {
        this.name = userDto.name();
        this.isActive = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<ChatServer> getChatServer() {
        return chatServer;
    }

    public void setChatServer(List<ChatServer> chatServer) {
        this.chatServer = chatServer;
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void disableAnUser(){
        setActive(false);
        setEndDate(LocalDateTime.now());
    }

    public void update(CreateUserDto updateUser) {
        this.name = name;
    }
}
