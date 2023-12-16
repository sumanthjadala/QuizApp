package com.sumanth.quiz.model;

import lombok.Data;

@Data
public class createQuizInput {
    Integer noOfQuestions;
    String category;
    String title;

}
