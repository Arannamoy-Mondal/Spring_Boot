package com.aranna.java18_spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    public ResponseEntity<?> getMethodName(@RequestParam String param) {
        try{
           return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
