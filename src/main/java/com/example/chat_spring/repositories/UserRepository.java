package com.example.chat_spring.repositories;

import com.example.chat_spring.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,String> {
    Page<User> findAllByIsActiveTrue(Pageable pageable);

    Optional<User> findByLogin(String login);
}
