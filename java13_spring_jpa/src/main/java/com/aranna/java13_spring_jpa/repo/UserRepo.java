package com.aranna.java13_spring_jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aranna.java13_spring_jpa.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

}
