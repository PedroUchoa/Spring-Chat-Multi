package com.example.chat_spring.enums;

public enum Role {

    ADMIN("admin"),
    USER("user");

    private String role;

    Role(String role){
        this.role = role;
    }

    String getRole(){
        return role;
    }

}
