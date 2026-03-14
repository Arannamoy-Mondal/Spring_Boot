package com.aranna.java20_spring_jwt_using_nimbus_jose.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aranna.java20_spring_jwt_using_nimbus_jose.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    User findByUserName(String userName);
}
