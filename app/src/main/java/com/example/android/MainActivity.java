package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void showQuiz (View view){
        Intent intentQuiz = new Intent(this, QuizActivity.class);

        /* Setting category chosen by user */
        switch (view.getId()) {
            case R.id.geography_button:
                intentQuiz.putExtra("category", "geography");
                break;

            case R.id.arts_button:
                intentQuiz.putExtra("category", "arts");
                break;

            case R.id.sports_button:
                intentQuiz.putExtra("category", "sports");
                break;

            case R.id.history_button:
                intentQuiz.putExtra("category", "history");
                break;
        }

        startActivity(intentQuiz);
    }


}
