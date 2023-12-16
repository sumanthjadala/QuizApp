package com.sumanth.quiz.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer quiz_id;
    String title;
    @ElementCollection
    List<Integer> questionsIds;
}
