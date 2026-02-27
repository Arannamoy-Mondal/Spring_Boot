package com.question_service.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question_service.question_service.model.Question;
import com.question_service.question_service.model.Response;
import com.question_service.question_service.repo.QuestionRepo;
import com.question_service.question_service.wrapper.QuestionWrapper;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    public List<Question> getAllQuestion() {
        return questionRepo.findAll();
    }

    public List<Question> getQuestion(String category) {
        return questionRepo.findByCategory(category);
    }

    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    public List<Question> loadQuestion() {
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
                        .build(),
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
                                .build()));
        return questionRepo.findAll();
    }

    public List<Integer> getQuestionsForQuiz(String category, int numQ) {
        List<Integer> questions=questionRepo.findRandomQuestionsByCategory(category,numQ);
        return questions;
    }

    public List<QuestionWrapper> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper>questionWrappers=new ArrayList<>();
        for(Integer i:questionIds){
            Question question=questionRepo.findById(i).orElse(null);
            if(question!=null){
                questionWrappers.add(
                    QuestionWrapper
                    .builder()
                    .id(question.getId())
                    .questionTitle(question.getQuestionTitle())
                    .option1(question.getOption1())
                    .option2(question.getOption2())
                    .option3(question.getOption3())
                    .option4(question.getOption4())
                    .build()
                );
            }
        }
        return questionWrappers;
    }

    public @Nullable Object getScore(List<Response> responses) {
        int right=0;
        for(Response response:responses){
            Question question=questionRepo.findById(response.getId()).orElse(null);
            if(question!=null){
                if(response.getResponse().equals(question.getRightAnswer())){
                    right++;
                }
            }

        }
        return right;
    }
    
}
