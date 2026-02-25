package com.java18_spring_security_project.java18_spring_security_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java18_spring_security_project.java18_spring_security_project.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    User findByUserName(String userName);
}
