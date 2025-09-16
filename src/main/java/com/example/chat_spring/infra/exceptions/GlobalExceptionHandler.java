package com.example.chat_spring.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginDuplicatedException.class)
    public ResponseEntity<ErrorMessage> handleLoginDuplicatedException(Exception ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.CONFLICT,ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(threatResponse);
    }

    @ExceptionHandler(ServerNameDuplicatedException.class)
    public ResponseEntity<ErrorMessage> handleServerNameDuplicatedException(Exception ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.CONFLICT,ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(threatResponse);
    }

    @ExceptionHandler(UserDuplicatedInChatException.class)
    public ResponseEntity<ErrorMessage> handleDuplicatedInChatException(Exception ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.CONFLICT,ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(threatResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(Exception ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler(LoginNotFoundException.class)
    public ResponseEntity<ErrorMessage> handLoginNotFoundException(Exception ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler(ServerNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleServerNotFoundException(Exception ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorMessage> handleBadCredentialsException(Exception ex){
        ErrorMessage threatResponse = new ErrorMessage(HttpStatus.UNAUTHORIZED,ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorMessage(HttpStatus.UNAUTHORIZED,"Login Or Password Invalids, Please Try Again!"));
    }


}
