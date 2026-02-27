package com.microservice.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.microservice.model.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {
    
}
