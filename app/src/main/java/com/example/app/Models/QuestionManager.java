package com.example.app.Models;


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

    public boolean checkAnswer(String userAnswer, Long questionId) {
        if(!this.questions.get(questionId).getAnswer().equals(userAnswer)){
            return false;
        } else {
            this.answeredQuestions.add(questionId);
            return true;
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
