package com.aranna.java13_spring_jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aranna.java13_spring_jpa.model.Passport;

public interface PassportRepo extends JpaRepository<Passport,Integer> {
    Passport findByIdAndCountry(Integer id,String country);
}
