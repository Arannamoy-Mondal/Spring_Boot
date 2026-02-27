package com.microservice.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.microservice.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAllQuiz(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(quizService.findQuizAll(id));
    }
    @PostMapping("/create")
    public ResponseEntity<?> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return ResponseEntity.status(HttpStatus.OK).body(quizService.createQuiz(category, numQ, title));
    }
}
