package com.example.chat_spring.repositories;

import com.example.chat_spring.dto.UserDtos.ReturnUserDto;
import com.example.chat_spring.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface UserRepository extends JpaRepository<User,Long> {
    Page<User> getAllUsersByIsActiveTrue(Pageable pageable);
}
