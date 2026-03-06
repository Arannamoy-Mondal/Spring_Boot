package com.aranna.java29_spring_pagination.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.java29_spring_pagination.model.User;
import com.aranna.java29_spring_pagination.repo.UserRepo;
import com.aranna.java29_spring_pagination.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ResponseEntity<?> getAllUser(@RequestParam(defaultValue = "10") int pageSize,
    @RequestParam(defaultValue = "10") int pageNum
) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageSize,pageNum));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
