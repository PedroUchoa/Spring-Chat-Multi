package com.example.chat_spring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name="chatMessage")
@Entity(name = "ChatMessage")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String content;
    @CreationTimestamp
    private LocalDateTime sendingTime;
    private String senderId;
    @ManyToOne
    @JoinColumn(name = "chat_server_id")
    @JsonBackReference
    private ChatServer chat;

    public ChatMessage() {}

    public ChatMessage(String id, String content, String senderId, LocalDateTime sendingTime, ChatServer chat) {
        this.id = id;
        this.content = content;
        this.senderId = senderId;
        this.sendingTime = sendingTime;
        this.chat = chat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChatServer getChat() {
        return chat;
    }

    public void setChat(ChatServer chat) {
        this.chat = chat;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public LocalDateTime getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(LocalDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
