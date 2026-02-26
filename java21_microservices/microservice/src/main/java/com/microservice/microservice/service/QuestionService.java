package com.microservice.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.microservice.model.Question;
import com.microservice.microservice.repo.QuestionRepo;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    public List<Question> getAllQuestion(){
        return questionRepo.findAll();
    }


    public List<Question> getQuestion(String category){
        return questionRepo.findByCategory(category);
    }


    public Question addQuestion(Question question){
        return questionRepo.save(question);
    }

    public List<Question> loadQuestion(){
        questionRepo.saveAll(
          List.of(Question
            .builder()
            .questionTitle("Whate is mvc?")
            .option1("Modern View Controller")
            .option2("Model View Controller")
            .option3("Model View Template")
            .option4("MVC + extra abstraction layer")
            .category("Framework")
            .difficultylevel("easy")
            .rightAnswer("Model View Controller")
            .build()
            ,
            Question
            .builder()
            .questionTitle("Whate is mvt?")
            .option1("Modern View Controller")
            .option2("Model View Controller")
            .option3("Model View Template")
            .option4("MVC + extra abstraction layer")
            .category("Framework")
            .difficultylevel("easy")
            .rightAnswer("Model View Template")
            .build()
        )  
        );
        return questionRepo.findAll();
    }
}
