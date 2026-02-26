package com.microservice.microservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.microservice.model.Question;
import com.microservice.microservice.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/load")
    public ResponseEntity<?> loadQuestion(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(questionService.loadQuestion());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }
    @GetMapping("/allQuestion")
    public ResponseEntity<?> getAllQuestion(){
        try {
            return ResponseEntity.status((HttpStatus.OK)).body(questionService.getAllQuestion());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    } 

    @GetMapping("/{category}")
    public ResponseEntity<?> getQuestion(@PathVariable("category") String category){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestion(category));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(questionService.addQuestion(question));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }

}
