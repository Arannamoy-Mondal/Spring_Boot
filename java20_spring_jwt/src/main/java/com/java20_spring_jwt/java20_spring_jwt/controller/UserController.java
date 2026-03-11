package com.java20_spring_jwt.java20_spring_jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java20_spring_jwt.java20_spring_jwt.user.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/signup")
    public ResponseEntity<?> postMethodName(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    @GetMapping("/users/{userName}")
    @PreAuthorize("hasRole('USER') and #userName==authentication.name")
    @PostAuthorize("returnObject.userName=='user'")
    public String getMethodName(@PathVariable("userName") String userName) {
        System.out.println(userName);
        return new String(userName);
    }
    
    
}
