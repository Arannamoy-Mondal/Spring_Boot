package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.model.User;
import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.repo.UserRepo;


@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String signup(User user){
        userRepo.save(
            User.builder()
            .username(user.getUsername())
            .password(new BCryptPasswordEncoder().encode(user.getPassword()))
            .build()
        );
        User result=userRepo.findByUsername(user.getUsername()).orElse(user);
        if(userRepo.existsById(result.getId())){
            return "Signup successful";
        } 
        else{
            return "Failed";
        }
    }
}
