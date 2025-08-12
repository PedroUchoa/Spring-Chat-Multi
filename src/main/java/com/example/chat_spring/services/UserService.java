package com.example.chat_spring.services;

import com.example.chat_spring.dto.UserDtos.CreateUserDto;
import com.example.chat_spring.dto.UserDtos.ReturnUserDto;
import com.example.chat_spring.models.User;
import com.example.chat_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ReturnUserDto createUser(CreateUserDto userDto){
        User user = userRepository.save(new User(userDto));
        return new ReturnUserDto(user);
    }

    public Page<ReturnUserDto> getAllUsers(Pageable pageable){
        return userRepository.getAllUsersByIsActiveTrue(pageable).map(ReturnUserDto::new);
    }

    public ReturnUserDto getUserById(String id){
        User user = userRepository.getReferenceById(id);
        return new ReturnUserDto(user);
    }

    public ReturnUserDto updateUser(CreateUserDto updateUser, String id){
        User user = userRepository.getReferenceById(id);
        user.update(updateUser);
        userRepository.save(user);
        return new ReturnUserDto(user);
    }

    public void deleteUser(String id){
        User user = userRepository.getReferenceById(id);
        user.disableAnUser();
        userRepository.save(user);
    }

}

