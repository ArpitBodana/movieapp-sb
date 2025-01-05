package com.movieshop.service_authentication.utils;

public class UserNameTakenException extends RuntimeException{
    public UserNameTakenException(String message){
        super(message);
    }
}
