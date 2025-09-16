package com.example.chat_spring.infra.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorMessage(HttpStatus status, String message) {
}
