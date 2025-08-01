package com.example.chat_spring.repositories;

import com.example.chat_spring.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long> {
    Page<User> getAllUsersByIsActiveTrue(Pageable pageable);
}
