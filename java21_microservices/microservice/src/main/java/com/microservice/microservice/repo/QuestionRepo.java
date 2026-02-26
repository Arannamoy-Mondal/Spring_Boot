package com.microservice.microservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.microservice.model.Question;


@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer>{
    List<Question> findByCategory(String category);
}
