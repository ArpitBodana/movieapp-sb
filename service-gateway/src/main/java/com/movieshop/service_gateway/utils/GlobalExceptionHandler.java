package com.movieshop.service_gateway.utils;

import com.movieshop.service_gateway.models.ApiError;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value= SignatureException.class)
    public ResponseEntity<ApiError> handleSignatureError(){
        ApiError error = new ApiError(401,"Token Expired or invalid.",new Date());
        return  new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }

}
