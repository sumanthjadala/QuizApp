package com.sumanth.quiz.model;


import lombok.Data;

@Data
public class QuestionWrapper 
{
	private int id;
	private String category;
	private String question_Title;
	private String option1;
	private String option2;
	private String option3;
	private String option4;


}
