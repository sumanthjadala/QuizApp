package com.sumanth.quiz.service;

import com.sumanth.quiz.Dao.QuizDao;
import com.sumanth.quiz.model.QuestionWrapper;
import com.sumanth.quiz.model.Quiz;
import com.sumanth.quiz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizInterface quizInterface;


    public Integer getScore(List<Response> responses) {
        return quizInterface.score(responses);
    }

    public List<QuestionWrapper> getQuestions(Integer id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Integer> questionsIds=quiz.get().getQuestionsIds();
        List<QuestionWrapper> questionWrappers=quizInterface.get(questionsIds);
        return questionWrappers;

    }

    public String createQuiz(Integer noOfQuestions, String category,String Title) {
        List<Integer> questionsIds=quizInterface.generate(noOfQuestions,category);
        Quiz quiz=new Quiz();
        quiz.setTitle(Title);
        quiz.setQuestionsIds(questionsIds);
        quizDao.save(quiz);
        return "Success";



    }
}
