package com.java20_spring_jwt.java20_spring_jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java20_spring_jwt.java20_spring_jwt.user.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/signup")
    public ResponseEntity<?> postMethodName(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    
}
