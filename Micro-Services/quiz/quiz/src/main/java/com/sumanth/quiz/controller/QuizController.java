package com.sumanth.quiz.controller;

import com.sumanth.quiz.model.QuestionWrapper;
import com.sumanth.quiz.model.Response;
import com.sumanth.quiz.model.createQuizInput;
import com.sumanth.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController{
    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public String create(@RequestBody createQuizInput input ){
        return quizService.createQuiz(input.getNoOfQuestions(),input.getCategory(),input.getTitle());
    }
    @GetMapping("/givequestions/{id}")
    public List<QuestionWrapper> allQuizQuestions(@PathVariable Integer id){
        return quizService.getQuestions(id);
    }
    @PostMapping("/getScore")
    public Integer getScore(@RequestBody List<Response> responses){
        return quizService.getScore(responses);
    }

}
