package com.sumanth.question.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sumanth.question.model.Question;
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	@Query(value = "select id from Question where category=:category order by random() limit :noOfQuestions ")
	List<Integer> getQuestionsIds(Integer noOfQuestions,String category);


}
