package com.example.chat_spring.models;

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
    private LocalDateTime creationDate;
    private LocalDateTime endDate;
    private Boolean isActive = true;
    @ManyToMany
    @JoinTable(
            name = "user_chat",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_message_id"))
    private List<ChatServer> chatServer = new ArrayList<>();

    public User() {}

    public User(List<ChatServer> chatServer, LocalDateTime endDate, Boolean isActive, LocalDateTime creationDate, String name, String id) {
        this.chatServer = chatServer;
        this.endDate = endDate;
        this.isActive = isActive;
        this.creationDate = creationDate;
        this.name = name;
        this.id = id;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
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

}
