package com.java18_spring_security_project.java18_spring_security_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java18_spring_security_project.java18_spring_security_project.model.User;
import com.java18_spring_security_project.java18_spring_security_project.model.UserPrinciple;
import com.java18_spring_security_project.java18_spring_security_project.repo.UserRepo;

@Service
public class UserDetailService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        User user=userRepo.findByUserName(username);
        if(user==null){
            System.out.println("user not found");
            return null;
        }
        else{
            return new UserPrinciple(user);
        }
        
    }
}
