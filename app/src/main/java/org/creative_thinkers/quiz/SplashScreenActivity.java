package org.creative_thinkers.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView link = (TextView) findViewById(R.id.developerLink);
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void startQuiz(View view){
        Intent questionActivityIntent = new Intent(this, QuestionActivity.class);
        startActivity(questionActivityIntent);
    }
}
