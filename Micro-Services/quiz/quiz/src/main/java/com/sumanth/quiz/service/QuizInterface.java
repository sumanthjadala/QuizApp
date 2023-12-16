package com.sumanth.quiz.service;

import com.sumanth.quiz.model.QuestionWrapper;
import com.sumanth.quiz.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("/question/generate")
    public List<Integer> generate(@RequestParam("noquestions") Integer noOfQuestions, @RequestParam("category") String category);
    @PostMapping("/question/getquestions")
    public List<QuestionWrapper> get(@RequestBody List<Integer> ids );
    @PostMapping("/question/getscore")
    public Integer score(@RequestBody List<Response> res);

}
