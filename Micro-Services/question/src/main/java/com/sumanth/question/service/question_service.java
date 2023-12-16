package com.sumanth.question.service;

import java.util.*;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.sumanth.question.dao.QuestionDao;
import com.sumanth.question.model.Question;
import com.sumanth.question.model.QuestionWrapper;
import com.sumanth.question.model.Response;

@Component
@Service
public class question_service 
{
	@Autowired
	QuestionDao questionDao;
	public List<Question> getAllquestion() {
		return questionDao.findAll();
	}
	public List<Question> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		return questionDao.findByCategory(category);
	}
	public ResponseEntity<Map<String,Object>> add(Question question) {
		Map<String,Object> error=new HashMap<>();
		if(validInform(question)) {
			error.put("suceess", false);
			error.put("error", "Invalid information");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		questionDao.save(question);
		System.out.println("save");
		return ResponseEntity.ok(error);

	}

	public List<Integer> giveQuestionIds(Integer noOfQuestions, String category) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionsIds(noOfQuestions,category);
	}

	boolean validInform(Question question) {
		Optional<Question> exist=questionDao.findById(question.getId());
		System.out.println(exist);
		if(!exist.isEmpty()|| question.getCategory().isEmpty() || question.getQuestion_Title().isEmpty()
				|| question.getCategory().isEmpty() || question.getOption1().isEmpty() ||
		question.getOption2().isEmpty() || question.getOption3().isEmpty() || question.getOption4().isEmpty()
		|| question.getRight_answer().isEmpty()){
			return true;
		}
		return false;
	}

	public List<QuestionWrapper> getquestions(List<Integer> ids) {
		List<QuestionWrapper> wrappers =new ArrayList<>();
		for(Integer id:ids) {
			Question que=questionDao.findById(id).get();
			QuestionWrapper wrapper=new QuestionWrapper();
			wrapper.setCategory(que.getCategory());
			wrapper.setId(que.getId());
			wrapper.setOption1(que.getOption1());
			wrapper.setOption2(que.getOption2());
			wrapper.setOption3(que.getOption3());
			wrapper.setOption4(que.getOption4());
			wrapper.setQuestion_Title(que.getQuestion_Title());
			wrappers.add(wrapper);		}
		return wrappers;
	}

	public Integer score(List<Response> res) {
		Integer scored=0;
		for(Response a:res) {
			Question que=questionDao.findById(a.getId()).get();
			if(a.getResponse().equals(que.getRight_answer())) {
				scored=scored+1;			
			}	
		}
		return scored;
	}

}
