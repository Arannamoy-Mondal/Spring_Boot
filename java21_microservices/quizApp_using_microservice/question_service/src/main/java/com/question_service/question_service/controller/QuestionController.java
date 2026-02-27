package com.question_service.question_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.question_service.question_service.model.Question;
import com.question_service.question_service.model.Response;
import com.question_service.question_service.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/load")
    public ResponseEntity<?> loadQuestion() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(questionService.loadQuestion());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }

    @GetMapping("/allQuestion")
    public ResponseEntity<?> getAllQuestion() {
        try {
            return ResponseEntity.status((HttpStatus.OK)).body(questionService.getAllQuestion());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }

    @GetMapping("/{category}")
    public ResponseEntity<?> getQuestion(@PathVariable("category") String category) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestion(category));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(questionService.addQuestion(question));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }

    // generate question
    // getQuestions (questionId)
    // getScore

    @GetMapping("/generate")
    public ResponseEntity<?> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numQ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionsForQuiz(category, numQ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<?> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionsFromId(questionIds));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }

    @PostMapping("/getScore")
    public ResponseEntity<?> getScore(@RequestBody List<Response> responses) {
        try{
            System.out.println(responses);
            return ResponseEntity.status(HttpStatus.OK).body(questionService.getScore(responses));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }
}
