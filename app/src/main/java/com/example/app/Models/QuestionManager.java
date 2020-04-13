package com.example.app.Models;

import com.example.app.Exceptions.WrongAnswerException;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Random;

public class QuestionManager {
    private Dictionary<Long, Question> questions;
    private List<Long> answeredQuestions;

    public QuestionManager(Dictionary<Long, Question> questions) {
        this.questions = questions;
        this.answeredQuestions = new ArrayList<Long>();
    }

    public Long submitAnswer(String userAnswer, Long questionId) throws WrongAnswerException {
        Question selectedQuestion = this.questions.get(questionId);
        if(!selectedQuestion.getAnswer().equals(userAnswer)){
            throw new WrongAnswerException();
        } else {
            this.answeredQuestions.add(questionId);
            return selectedQuestion.getPoints();
        }
    }

    public char getHint(int charIndex, Long questionId){
        return this.questions.get(questionId).getAnswer().charAt(charIndex);
    }

    public Question getNextQuestion() {
        Random rand = new Random();
        long nextQuestionId = rand.nextInt(this.questions.size());
        while(this.answeredQuestions.contains(nextQuestionId)){
            nextQuestionId = rand.nextInt(this.questions.size());
        }
        return this.questions.get(nextQuestionId);
    }

}
