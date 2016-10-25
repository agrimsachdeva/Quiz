package org.creative_thinkers.quiz;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = this.getIntent();
        score = intent.getExtras().getInt("score");

        TextView scoreView = (TextView) findViewById(R.id.score);

        Resources res = getResources();
        String[] strings = res.getStringArray(R.array.feedback);

        scoreView.setText(strings[score]);

    }

    public void startAgain(View view) {

        Intent intent = new Intent(this, SplashScreenActivity.class);
        startActivity(intent);
        finish();
    }

    public void share(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "My score is " + score);
        startActivity(Intent.createChooser(intent, getResources().getText(R.string.send_to)));
    }
}
