package com.example.chat_spring.controllers;

import com.example.chat_spring.dto.UserDtos.CreateUserDto;
import com.example.chat_spring.dto.UserDtos.ReturnUserDto;
import com.example.chat_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<ReturnUserDto> creteUser(@RequestBody CreateUserDto createUserDto, UriComponentsBuilder uri){
        ReturnUserDto returnUserDto = userService.createUser(createUserDto);
        URI location = uri.path("/id")
                .buildAndExpand(returnUserDto.id())
                .toUri();
        return ResponseEntity.created(location).body(returnUserDto);
    }

    @GetMapping
    public ResponseEntity<Page<ReturnUserDto>> getAllUsers(@PageableDefault(sort = {"id"})Pageable pageable){
        Page<ReturnUserDto> user = userService.getAllUsers(pageable);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnUserDto> getUserById(@PathVariable Long id){
        ReturnUserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ReturnUserDto> updateUser(@RequestBody CreateUserDto createUserDto, @PathVariable Long id){
        ReturnUserDto userDto = userService.updateUser(createUserDto,id);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
