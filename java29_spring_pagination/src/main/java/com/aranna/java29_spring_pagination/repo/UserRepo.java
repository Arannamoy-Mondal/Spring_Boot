package com.aranna.java29_spring_pagination.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aranna.java29_spring_pagination.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
