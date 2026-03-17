package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.model.User;
import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public String signup(@RequestBody User entity) {
        return userService.signup(entity);
    }
    
}
