package com.aranna.java20_spring_jwt_v2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aranna.java20_spring_jwt_v2.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.aranna.java20_spring_jwt_v2.model.User user=userRepo.findByUserName(userName);
        if(user==null){
            System.out.println("User 404");
        }
        return new UserPrincipal(user);
    }
}
