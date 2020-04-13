package com.example.app.Models;

public class Question {
    private Long id;
    private String description;
    private Long points;
    private String Answer;

    public Question(Long id, String description, Long points, String answer) {
        this.id = id;
        this.description = description;
        this.points = points;
        Answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
