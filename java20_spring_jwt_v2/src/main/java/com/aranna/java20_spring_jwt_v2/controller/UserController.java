package com.aranna.java20_spring_jwt_v2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private List<User> getUsers() {
        List<User> users = userRepo.findAll();
        if (users.size() > 0) {
            return users;
        } else {
            userRepo.save(
                    User.builder()
                            .userName("user1")
                            .password("1234")
                            .build());
            return userRepo.findAll();
        }
        // return null;
    }

    @PostMapping("/signup")
    public Object signup(@RequestBody User user) {
        if (userRepo.existsByUserName(user.getUserName())) {
            return "Username already exist";
        } else {
            System.out.println(user);
            user.setPassword(bCryptPasswordEncoder(user.getPassword()));
            userRepo.save(user);
            return userRepo.findAll();
        }
    }

    private String bCryptPasswordEncoder(String password) {
    return new BCryptPasswordEncoder(12).encode(password);
    }
}
