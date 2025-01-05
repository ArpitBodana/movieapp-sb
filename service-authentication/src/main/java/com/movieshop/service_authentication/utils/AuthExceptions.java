package com.movieshop.service_authentication.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class AuthExceptions {

    @ExceptionHandler(value= UserNameTakenException.class)
    public ResponseEntity<String> userExistException(){
        return new ResponseEntity<>("Username already exists . Please take another username", HttpStatus.CONFLICT);
    }
}
