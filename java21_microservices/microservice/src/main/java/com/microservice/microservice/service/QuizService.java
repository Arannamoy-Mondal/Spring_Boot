package com.microservice.microservice.service;


import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.microservice.model.Question;
import com.microservice.microservice.model.Quiz;
import com.microservice.microservice.repo.QuestionRepo;
import com.microservice.microservice.repo.QuizRepo;
import com.microservice.microservice.wrapper.QuestionWrapper;

@Service
public class QuizService {
    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuestionRepo questionRepo;
    public Quiz createQuiz(String category,int numQ,String title){
        List<Question> questions=questionRepo.findRandomQuestionsByCategory(category,numQ);
        Quiz  quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return quiz;
    }
    public List<QuestionWrapper> findQuizAll(int id) {
        Quiz quiz= quizRepo.findById(id).orElse(null);
        List<Question> questions=quiz.getQuestions();
        List<QuestionWrapper> questionWrappers=new ArrayList<>();
        for(Question question:questions){
            questionWrappers.add(QuestionWrapper
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
        return questionWrappers;
    }
}
