package com.example.app.Models;

import com.example.app.Exceptions.WrongAnswerException;

import java.util.Dictionary;

public class QuestionChecker {
    private Dictionary<Long, Question> questions;

    public QuestionChecker(Dictionary<Long, Question> questions) {
        this.questions = questions;
    }

    public Long submitAnswer(String userAnswer, Long questionId) throws WrongAnswerException {
        Question selectedQuestion = this.questions.get(questionId);
        if(!selectedQuestion.getAnswer().equals(userAnswer)){
            throw new WrongAnswerException();
        }
        return selectedQuestion.getPoints();
    }

    public char getHint(int charIndex, Long questionId){
        return this.questions.get(questionId).getAnswer().charAt(charIndex);
    }
}
