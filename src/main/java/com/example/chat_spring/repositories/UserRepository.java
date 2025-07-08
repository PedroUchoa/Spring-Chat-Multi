package com.example.chat_spring.repositories;

import com.example.chat_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
