package com.sumanth.question;

import com.sumanth.question.model.Question;
import com.sumanth.question.model.QuestionWrapper;
import com.sumanth.question.model.Response;
import com.sumanth.question.service.question_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class questionController {
	@Autowired
	question_service questionService;
    @GetMapping("/getquestions")
    public List<Question> questions(){
    	return questionService.getAllquestion();
        
    }
    @GetMapping("/getquestion/{categor}")
    public List<Question> getquestion(@PathVariable("categor") String category){
    	return questionService.getQuestionByCategory(category);   
    	}
    @PostMapping("/add")
    public ResponseEntity<Map<String,Object>> add(@RequestBody Question q) {
    	return questionService.add(q);
    }
    @GetMapping("/generate")
    public List<Integer> generate(@RequestParam("noquestions") Integer noOfQuestions,@RequestParam("category") String category){
    	return questionService.giveQuestionIds(noOfQuestions,category);
    }
    @PostMapping("/getquestions")
    public List<QuestionWrapper> get(@RequestBody List<Integer> ids ){
    	return questionService.getquestions(ids);
    }
    @PostMapping("/getscore")
    public Integer  score(@RequestBody List<Response> res){
    	return questionService.score(res);
    }
}
