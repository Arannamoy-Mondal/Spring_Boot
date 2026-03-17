package com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aranna.java20_spring_jwt_using_nimbus_jose_asymmetric.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}
