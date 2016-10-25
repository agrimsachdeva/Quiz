package org.creative_thinkers.quiz.data;

import java.util.ArrayList;
import java.util.List;

public class Questions {

    private List<Question> questions;

    public Questions() {
        questions = new ArrayList<Question>();

        List<String> answers1 = new ArrayList<String>();
        answers1.add("white");
        answers1.add("orange");
        answers1.add("black");

        questions.add(new Question("Question 1 of 3", "What color is the sun?", answers1, 1, true,false));

        List<String> answers2 = new ArrayList<String>();
        answers2.add("16");
        answers2.add("21");
        answers2.add("11");
        questions.add(new Question("Question 2 of 3", "What is 7 + 9?", answers2, 0, false,false));

        List<String> answers3 = new ArrayList<String>();
        answers3.add("Sample");
        answers3.add("Suggestion");
        answers3.add("States");
        questions.add(new Question("Question 3 of 3", "What does the 'S' stand for in 'USA'?", answers3, 2, false,true));

    }

    public Question getQuestion(int id) {
        return questions.get(id);
    }

    public int calculateScore() {
        int correct = 0;
        for (Question next : questions){
            if (next.getUsersGuess() == next.getCorrectAnswer()) {
                correct++;
            }
        }
        return correct;
    }

}
