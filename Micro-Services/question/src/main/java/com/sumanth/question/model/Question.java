package com.sumanth.question.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;


@Entity
@Data
public class Question 
{
	@Id
	private int id;
	private String category;
	private String question_Title;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String right_answer;

	
}
