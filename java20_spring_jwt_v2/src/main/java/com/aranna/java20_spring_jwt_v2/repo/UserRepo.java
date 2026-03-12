package com.aranna.java20_spring_jwt_v2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aranna.java20_spring_jwt_v2.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    User findByUserName(String userName);
}
