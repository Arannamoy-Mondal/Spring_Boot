package com.aranna.java20_spring_jwt_v2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.java20_spring_jwt_v2.model.User;
import com.aranna.java20_spring_jwt_v2.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/load")
    private List<User> getUsers(){
        List<User> users=userRepo.findAll();
        if(users.size()>0){
            return users;
        }
        else{
            userRepo.save(
                User.builder()
                .userName("user1")
                .password("1234")
                .build()
            );
            return userRepo.findAll();
        }
        // return null;
    }
}
