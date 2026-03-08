package com.aranna.java30_spring_validation;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
public class UserController {
    @PostMapping("/user")
    public User postMethodName(@Valid@RequestBody User user
        ,BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return null;
        }
        else{
            System.out.println(user);
        return user;
        }
    }
    
    @GetMapping("/")
    public String getMethodName() {
        return new String("hello");
    }
    
}
