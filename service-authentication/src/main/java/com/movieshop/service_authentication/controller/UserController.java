package com.movieshop.service_authentication.controller;

import com.movieshop.service_authentication.models.User;
import com.movieshop.service_authentication.models.UserCredentials;
import com.movieshop.service_authentication.service.JwtUtil;
import com.movieshop.service_authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "Authorization")
@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserCredentials user) {
        return ResponseEntity.ok(service.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserCredentials user) {
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            return ResponseEntity.ok(jwtUtil.generateToken(user.getUsername()));
//            if (authentication.isAuthenticated()) {
//                return ResponseEntity.ok(jwtUtil.generateToken(user.getUsername()));
//
//            } else {
//                return new ResponseEntity<>("Login Failed",HttpStatus.UNAUTHORIZED);
//            }
        }catch (BadCredentialsException e) {
            return new ResponseEntity<>("Login Failed: Incorrect username or password", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>("Login Failed: An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable String userId){
        return new ResponseEntity<>(service.deleteUser(userId), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable String id){
        return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
    }
}

