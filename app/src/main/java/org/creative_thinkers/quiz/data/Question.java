package org.creative_thinkers.quiz.data;

import java.util.List;

public class Question {
    private String title;
    private String text;
    private List<String> answers;
    private int correctAnswer;
    private Integer usersGuess;
    private boolean firstQuestion;
    private boolean lastQuestion;

    public Question(String title, String text, List<String> answers, int correctAnswer, boolean firstQuestion, boolean lastQuestion) {
        this.title = title;
        this.text = text;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.firstQuestion = firstQuestion;
        this.lastQuestion = lastQuestion;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isFirstQuestion() {
        return firstQuestion;
    }

    public boolean isLastQuestion() {
        return lastQuestion;
    }

    public Integer getUsersGuess() {
        return usersGuess;
    }

    public void setUsersGuess(Integer usersGuess) {
        this.usersGuess = usersGuess;
    }

}