package org.creative_thinkers.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.creative_thinkers.quiz.data.Question;
import org.creative_thinkers.quiz.data.Questions;

public class QuestionActivity extends Activity {

    private Questions questions;
    private int currentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questions = new Questions();
        currentId = 0;

        showQuestion();
    }

    private void showQuestion() {
        Question question = questions.getQuestion(currentId);

        TextView title = (TextView) findViewById(R.id.QuestionTitle);
        title.setText(question.getTitle());

        TextView questionText = (TextView) findViewById(R.id.QuestionText);
        questionText.setText(question.getText());

        RadioButton answer1 = (RadioButton) findViewById(R.id.answer1);
        answer1.setText(question.getAnswers().get(0));

        RadioButton answer2 = (RadioButton) findViewById(R.id.answer2);
        answer2.setText(question.getAnswers().get(1));

        RadioButton answer3 = (RadioButton) findViewById(R.id.answer3);
        answer3.setText(question.getAnswers().get(2));


        Button nextButton = (Button) findViewById(R.id.nextButton);
        Question currentQuestion = questions.getQuestion(currentId);

        if(currentQuestion.getUsersGuess() == null) {
            nextButton.setEnabled(false);
        } else {
            nextButton.setEnabled(true);
        }


        Button backButton = (Button) findViewById(R.id.backButton);
        if (question.isFirstQuestion()){
            backButton.setVisibility(View.INVISIBLE);
        } else {
            backButton.setVisibility(View.VISIBLE);
        }

        //restore the state of radio buttons

        Integer guess = currentQuestion.getUsersGuess();
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.answers);

        if (guess == null){
            radioGroup.clearCheck();
        } else {
            View selectedItem = radioGroup.getChildAt(guess);
            radioGroup.check(selectedItem.getId());
        }

    }

    public void answerSelected(View radioButtonThatWasClicked){
        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setEnabled(true);

        Question currentQuestion = questions.getQuestion(currentId);

        RadioGroup group = (RadioGroup) findViewById(R.id.answers);


        int positionOfClickedButton = group.indexOfChild(radioButtonThatWasClicked);

        currentQuestion.setUsersGuess(positionOfClickedButton);
    }

    public void nextButtonClick (View view){

        if (questions.getQuestion(currentId).isLastQuestion()){
            // move to the score
            Intent scoreIntent = new Intent(this, ScoreActivity.class);
            scoreIntent.putExtra("score", questions.calculateScore());

            startActivity(scoreIntent);
            finish();
        } else {

            currentId++;
            showQuestion();
        }
    }


    public void backButtonClick (View view){

        currentId--;
        showQuestion();

    }


}
