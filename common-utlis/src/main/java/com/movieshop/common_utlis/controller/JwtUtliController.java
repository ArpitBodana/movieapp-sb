package com.movieshop.common_utlis.controller;

import com.movieshop.common_utlis.services.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/common/jwt")
public class JwtUtliController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/generateToken")
    public ResponseEntity<String> generateTokenForUser(@RequestBody String username){
        return new ResponseEntity<>(jwtUtil.generateToken(username), HttpStatus.OK);
    }

    @PostMapping("/validateToken")
    public ResponseEntity<Boolean> validateToken(@RequestBody String token,@RequestBody String username){
        return new ResponseEntity<>(jwtUtil.validateToken(token,username),HttpStatus.OK);
    }

    @PostMapping("/extractUsername")
    public ResponseEntity<String> extractUsername(@RequestBody String token){
        return new ResponseEntity<>(jwtUtil.extractUsername(token),HttpStatus.OK);
    }

}
