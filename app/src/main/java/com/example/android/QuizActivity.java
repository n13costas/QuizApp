package com.example.android.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity{

    /*Array of questions for all categories. */
    public String[] arrayQuestions = {"What is the capital of Greece?", "Which of these countries are islands?", "How many states in the U.S.A.", "Which band wrote the 'Bohemian Rhapsody'?", "Who painted 'Mona Lisa'?", "Who actors played Gandalf and Saruman in 'Lord of the Rings'?", "Which Japanese cities were hit by an atomic bomb?", "Who was the U.S.A. President between 2009 and 2017 ?", "Which year did the Berlin wall fall??", "Which team has won the most Champions League?", "Who is also known as the 'Greek Freak'?", "Which teams played in the final of World Cup 2014?"};

    /* Current question for each category. */
    public int currentQuestion = 0;

    /* Number of correct answers for each category. */
    public int correctGeographyAnswers = 0;
    public int correctArtsAnswers = 0;
    public int correctHistoryAnswers = 0;
    public int correctSportsAnswers = 0;

    /* Selected Answer id */
    public int selectedId;

    /* Results variables */
    public boolean question1IsCorrect = false;
    public boolean question2IsCorrect = false;
    public boolean question3IsCorrect = false;
    public boolean question4IsCorrect = false;
    public boolean question5IsCorrect = false;
    public boolean question6IsCorrect = false;
    public boolean question7IsCorrect = false;
    public boolean question8IsCorrect = false;
    public boolean question9IsCorrect = false;
    public boolean question10IsCorrect = false;
    public boolean question11IsCorrect = false;
    public boolean question12IsCorrect = false;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        /* Getting category chosen by user */
        Intent intentQuiz = getIntent();
        String chosenCategory = intentQuiz.getStringExtra("category");

        final TextView quizHeader = findViewById(R.id.quiz_header);
        final TextView quizQuestion = findViewById(R.id.quiz_question);

        /* Initiating question depending on category chosen by user and styling the questions*/
        switch (chosenCategory) {
            case "geography":
                quizHeader.setBackgroundColor(Color.parseColor("#9900b0ff"));
                quizQuestion.setBackgroundColor(Color.parseColor("#9900b0ff"));
                currentQuestion = 0;
                break;

            case "arts":
                quizHeader.setText("Arts Quiz");
                quizHeader.setBackgroundColor(Color.parseColor("#9900c853"));
                quizQuestion.setBackgroundColor(Color.parseColor("#9900c853"));
                currentQuestion = 3;
                break;

            case "history":
                quizHeader.setText("History Quiz");
                quizHeader.setBackgroundColor(Color.parseColor("#99ff6f00"));
                quizQuestion.setBackgroundColor(Color.parseColor("#99ff6f00"));
                currentQuestion = 6;
                break;

            case "sports":
                quizHeader.setText("Sports Quiz");
                quizHeader.setBackgroundColor(Color.parseColor("#99c62828"));
                quizQuestion.setBackgroundColor(Color.parseColor("#99c62828"));
                currentQuestion = 9;
                break;
        }

        showQuestion(currentQuestion);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save the current questions state
        savedInstanceState.putInt("STATE_CURRENT_QUESTION", currentQuestion);

        // Save the user's questions state
        savedInstanceState.putBoolean("STATE_QUESTION_1", question1IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_2", question2IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_3", question3IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_4", question4IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_5", question5IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_6", question6IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_7", question7IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_8", question8IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_9", question9IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_10", question10IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_11", question11IsCorrect);
        savedInstanceState.putBoolean("STATE_QUESTION_12", question12IsCorrect);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        //  Restore state of current questions from saved instance
        currentQuestion = savedInstanceState.getInt("STATE_CURRENT_QUESTION");

        // Restore state of correct questions from saved instance
        question1IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_1");
        question2IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_2");
        question3IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_3");
        question4IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_4");
        question5IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_5");
        question6IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_6");
        question7IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_7");
        question8IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_8");
        question9IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_9");
        question10IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_10");
        question11IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_11");
        question12IsCorrect = savedInstanceState.getBoolean("STATE_QUESTION_12");

        showQuestion(currentQuestion);
    }

    /* Setting the question view */
    public void showQuestion (int questionNumber) {

        /* Setting appropriate quiz header */
        TextView quizHeader = findViewById(R.id.quiz_header);
        if ( currentQuestion <= 2 ) {
            quizHeader.setText("Geography Quiz");
        } else if ( currentQuestion <= 5 ){
            quizHeader.setText("Arts Quiz");
        } else if ( currentQuestion <= 8 ) {
            quizHeader.setText("History Quiz");
        } else {
            quizHeader.setText("Sports Quiz");
        }

        /* Setting appropriate question */
        TextView quizQuestion = findViewById(R.id.quiz_question);
        quizQuestion.setText(arrayQuestions[questionNumber]);

        /* Showing or hiding PREV button */
        Button prevButton = findViewById(R.id.button_previous);
        if ( currentQuestion == 1 || currentQuestion == 2 || currentQuestion == 4 || currentQuestion == 5 || currentQuestion == 7 || currentQuestion == 8 || currentQuestion == 10 || currentQuestion == 11 ){
            prevButton.setVisibility(View.VISIBLE);
        } else {
            prevButton.setVisibility(View.INVISIBLE);
        }

        /* Showing or hiding NEXT button */
        Button nextButton = findViewById(R.id.button_next);
        if ( currentQuestion == 0 || currentQuestion == 1 || currentQuestion == 3 || currentQuestion == 4 || currentQuestion == 6 || currentQuestion == 7 || currentQuestion == 9 || currentQuestion == 10 ){
            nextButton.setVisibility(View.VISIBLE);
        } else {
            nextButton.setVisibility(View.INVISIBLE);
        }

        /* Showing or hiding SUBMIT button */
        Button submitButton = findViewById(R.id.button_submit);
        if ( currentQuestion == 2 || currentQuestion == 5 || currentQuestion == 8 || currentQuestion == 11 ){
            submitButton.setVisibility(View.VISIBLE);
        } else {
            submitButton.setVisibility(View.INVISIBLE);
        }

        showAnswers(currentQuestion);
    }

    /* Setting the answers view */
    public void showAnswers (int questionNumber) {

        View GeographyAnswers = findViewById(R.id.geography_layout);
        View ArtsAnswers = findViewById(R.id.arts_layout);
        View HistoryAnswers = findViewById(R.id.history_layout);
        View SportsAnswers = findViewById(R.id.sports_layout);

        /* Deciding which categories answers to show */
        if ( currentQuestion <= 2 ) {
            GeographyAnswers.setVisibility(View.VISIBLE);
            ArtsAnswers.setVisibility(View.INVISIBLE);
            HistoryAnswers.setVisibility(View.INVISIBLE);
            SportsAnswers.setVisibility(View.INVISIBLE);
        } else if ( currentQuestion <= 5 ){
            GeographyAnswers.setVisibility(View.INVISIBLE);
            ArtsAnswers.setVisibility(View.VISIBLE);
            HistoryAnswers.setVisibility(View.INVISIBLE);
            SportsAnswers.setVisibility(View.INVISIBLE);
        } else if ( currentQuestion <= 8 ) {
            GeographyAnswers.setVisibility(View.INVISIBLE);
            ArtsAnswers.setVisibility(View.INVISIBLE);
            HistoryAnswers.setVisibility(View.VISIBLE);
            SportsAnswers.setVisibility(View.INVISIBLE);
        } else {
            GeographyAnswers.setVisibility(View.INVISIBLE);
            ArtsAnswers.setVisibility(View.INVISIBLE);
            HistoryAnswers.setVisibility(View.INVISIBLE);
            SportsAnswers.setVisibility(View.VISIBLE);
        }

        /* Deciding which answer to show */
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        View checkGroup1 = findViewById(R.id.checkGroup1);
        EditText textView3 = findViewById(R.id.text_view_usa);
        RadioGroup radioGroup4 = findViewById(R.id.radioGroup4);
        RadioGroup radioGroup5 = findViewById(R.id.radioGroup5);
        View checkGroup6 = findViewById(R.id.checkGroup6);
        View checkGroup7 = findViewById(R.id.checkGroup7);
        RadioGroup radioGroup8 = findViewById(R.id.radioGroup8);
        RadioGroup radioGroup9 = findViewById(R.id.radioGroup9);
        RadioGroup radioGroup10 = findViewById(R.id.radioGroup10);
        RadioGroup radioGroup11 = findViewById(R.id.radioGroup11);
        View checkGroup12 = findViewById(R.id.checkGroup12);

        switch (questionNumber) {
            case 0:
                radioGroup1.setVisibility(View.VISIBLE);
                checkGroup1.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                break;

            case 1:
                radioGroup1.setVisibility(View.INVISIBLE);
                checkGroup1.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                break;

            case 2:
                radioGroup1.setVisibility(View.INVISIBLE);
                checkGroup1.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.VISIBLE);
                break;
            case 3:
                radioGroup4.setVisibility(View.VISIBLE);
                radioGroup5.setVisibility(View.INVISIBLE);
                checkGroup6.setVisibility(View.INVISIBLE);
                break;

            case 4:
                radioGroup4.setVisibility(View.INVISIBLE);
                radioGroup5.setVisibility(View.VISIBLE);
                checkGroup6.setVisibility(View.INVISIBLE);
                break;

            case 5:
                radioGroup4.setVisibility(View.INVISIBLE);
                radioGroup5.setVisibility(View.INVISIBLE);
                checkGroup6.setVisibility(View.VISIBLE);
                break;
            case 6:
                checkGroup7.setVisibility(View.VISIBLE);
                radioGroup8.setVisibility(View.INVISIBLE);
                radioGroup9.setVisibility(View.INVISIBLE);
                break;

            case 7:
                checkGroup7.setVisibility(View.INVISIBLE);
                radioGroup8.setVisibility(View.VISIBLE);
                radioGroup9.setVisibility(View.INVISIBLE);
                break;

            case 8:
                checkGroup7.setVisibility(View.INVISIBLE);
                radioGroup8.setVisibility(View.INVISIBLE);
                radioGroup9.setVisibility(View.VISIBLE);
                break;
            case 9:
                radioGroup10.setVisibility(View.VISIBLE);
                radioGroup11.setVisibility(View.INVISIBLE);
                checkGroup12.setVisibility(View.INVISIBLE);
                break;

            case 10:
                radioGroup10.setVisibility(View.INVISIBLE);
                radioGroup11.setVisibility(View.VISIBLE);
                checkGroup12.setVisibility(View.INVISIBLE);
                break;

            case 11:
                radioGroup10.setVisibility(View.INVISIBLE);
                radioGroup11.setVisibility(View.INVISIBLE);
                checkGroup12.setVisibility(View.VISIBLE);
                break;
        }
    }

    /* Showing next question */
    public void nextQuestion (View view) {
        currentQuestion++;
        showQuestion(currentQuestion);
    }

    /* Showing previous question */
    public void previousQuestion (View view) {
        currentQuestion--;
        showQuestion(currentQuestion);
    }

    public int getNumberstates(){
        EditText textView3 = findViewById(R.id.text_view_usa);
        int states = Integer.parseInt(textView3.getText().toString());
        return states;
    }

    /* Finding correct answers for radio buttons questions */
    public void onRadioButtonClicked1 (View view) {
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        if ( getRadioCorrectAnswer(radioGroup1, "Athens") ) {
            question1IsCorrect = true;
        } else {
            question1IsCorrect = false;
        }
    }

    public void onRadioButtonClicked4 (View view) {
        RadioGroup radioGroup4 = findViewById(R.id.radioGroup4);
        if ( getRadioCorrectAnswer(radioGroup4, "Queen") ) {
            question4IsCorrect = true;
        } else {
            question4IsCorrect = false;
        }
    }

    public void onRadioButtonClicked5 (View view) {
        RadioGroup radioGroup5 = findViewById(R.id.radioGroup5);
        if ( getRadioCorrectAnswer(radioGroup5, "Leonardo da Vinci") ) {
            question5IsCorrect = true;
        } else {
            question5IsCorrect = false;
        }
    }

    public void onRadioButtonClicked8 (View view) {
        RadioGroup radioGroup8 = findViewById(R.id.radioGroup8);
        if ( getRadioCorrectAnswer(radioGroup8, "Barack Obama") ) {
            question8IsCorrect = true;
        } else {
            question8IsCorrect = false;
        }
    }

    public void onRadioButtonClicked9 (View view) {
        RadioGroup radioGroup9 = findViewById(R.id.radioGroup9);
        if ( getRadioCorrectAnswer(radioGroup9, "1989") ) {
            question9IsCorrect = true;
        } else {
            question9IsCorrect = false;
        }
    }

    public void onRadioButtonClicked10 (View view) {
        RadioGroup radioGroup10 = findViewById(R.id.radioGroup10);
        if ( getRadioCorrectAnswer(radioGroup10, "Real Madrid") ) {
            question10IsCorrect = true;
        } else {
            question10IsCorrect = false;
        }
    }

    public void onRadioButtonClicked11 (View view) {
        RadioGroup radioGroup11 = findViewById(R.id.radioGroup11);
        if ( getRadioCorrectAnswer(radioGroup11, "Giannis Antetokounbo") ) {
            question11IsCorrect = true;
        } else {
            question11IsCorrect = false;
        }
    }

    /* Calling this method to decide the equality of user answer and correct answer */
    public boolean getRadioCorrectAnswer (RadioGroup radioGroup, String correctAnswer) {
        selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        String selectedText = radioButton.getText().toString();
        TextView quizHeader = findViewById(R.id.quiz_header);
        quizHeader.setText(selectedText);
        if ( selectedText.equals(correctAnswer) ){
            return true;
        } else {
            return false;
        }
    }

    /* Finding correct answers for check boxes questions */
    public void onCheckboxClicked1 (View view) {
        CheckBox CheckBox1 = findViewById(R.id.checkbox_cyprus);
        CheckBox CheckBox2 = findViewById(R.id.checkbox_finland);
        CheckBox CheckBox3 = findViewById(R.id.checkbox_malta);
        CheckBox CheckBox4 = findViewById(R.id.checkbox_iceland);

        boolean checkbox1Checked = CheckBox1.isChecked();
        boolean checkbox2Checked = CheckBox2.isChecked();
        boolean checkbox3Checked = CheckBox3.isChecked();
        boolean checkbox4Checked = CheckBox4.isChecked();

        // Check which checkbox was clicked
        if ( checkbox1Checked == true && checkbox2Checked == false && checkbox3Checked == true && checkbox4Checked == true ) {
            question2IsCorrect = true;
        } else {
            question2IsCorrect = false;
        }
    }

    public void onCheckboxClicked6 (View view) {
        CheckBox CheckBox1 = findViewById(R.id.checkbox_lee);
        CheckBox CheckBox2 = findViewById(R.id.checkbox_redford);
        CheckBox CheckBox3 = findViewById(R.id.checkbox_mckellen);
        CheckBox CheckBox4 = findViewById(R.id.checkbox_mortensen);

        boolean checkbox1Checked = CheckBox1.isChecked();
        boolean checkbox2Checked = CheckBox2.isChecked();
        boolean checkbox3Checked = CheckBox3.isChecked();
        boolean checkbox4Checked = CheckBox4.isChecked();

        // Check which checkbox was clicked
        if ( checkbox1Checked == true && checkbox2Checked == false && checkbox3Checked == true && checkbox4Checked == false ) {
            question6IsCorrect = true;
        } else {
            question6IsCorrect = false;
        }
    }

    public void onCheckboxClicked7 (View view) {
        CheckBox CheckBox1 = findViewById(R.id.checkbox_hiroshima);
        CheckBox CheckBox2 = findViewById(R.id.checkbox_tokyo);
        CheckBox CheckBox3 = findViewById(R.id.checkbox_fukushima);
        CheckBox CheckBox4 = findViewById(R.id.checkbox_nagasaki);

        boolean checkbox1Checked = CheckBox1.isChecked();
        boolean checkbox2Checked = CheckBox2.isChecked();
        boolean checkbox3Checked = CheckBox3.isChecked();
        boolean checkbox4Checked = CheckBox4.isChecked();

        // Check which checkbox was clicked
        if ( checkbox1Checked == true && checkbox2Checked == false && checkbox3Checked == false && checkbox4Checked == true ) {
            question7IsCorrect = true;
        } else {
            question7IsCorrect = false;
        }
    }

    public void onCheckboxClicked12 (View view) {
        CheckBox CheckBox1 = findViewById(R.id.checkbox_brazil);
        CheckBox CheckBox2 = findViewById(R.id.checkbox_germany);
        CheckBox CheckBox3 = findViewById(R.id.checkbox_argentina);
        CheckBox CheckBox4 = findViewById(R.id.checkbox_italy);

        boolean checkbox1Checked = CheckBox1.isChecked();
        boolean checkbox2Checked = CheckBox2.isChecked();
        boolean checkbox3Checked = CheckBox3.isChecked();
        boolean checkbox4Checked = CheckBox4.isChecked();

        // Check which checkbox was clicked
        if ( checkbox1Checked == false && checkbox2Checked == true && checkbox3Checked == true && checkbox4Checked == false ) {
            question12IsCorrect = true;
        } else {
            question12IsCorrect = false;
        }
    }


    /* Deciding how many correct answers for each category and showing relative toast */
    public void returnHome (View view){

        /* Geography correct answer to editText */
        if ( currentQuestion <= 3){
            if ( getNumberstates() == 50) {
                question3IsCorrect = true;
            }
        }

        /* Geography correct answers */
        if ( question1IsCorrect ) {
            correctGeographyAnswers++;
        }
        if ( question2IsCorrect ) {
            correctGeographyAnswers++;
        }
        if ( question3IsCorrect ) {
            correctGeographyAnswers++;
        }

        /* Arts correct answers */
        if ( question4IsCorrect ) {
            correctArtsAnswers++;
        }
        if ( question5IsCorrect ) {
            correctArtsAnswers++;
        }
        if ( question6IsCorrect ) {
            correctArtsAnswers++;
        }

        /* History correct answers */
        if ( question7IsCorrect ) {
            correctHistoryAnswers++;
        }
        if ( question8IsCorrect ) {
            correctHistoryAnswers++;
        }
        if ( question9IsCorrect ) {
            correctHistoryAnswers++;
        }

        /* Sports correct answers */
        if ( question10IsCorrect ) {
            correctSportsAnswers++;
        }
        if ( question11IsCorrect ) {
            correctSportsAnswers++;
        }
        if ( question12IsCorrect ) {
            correctSportsAnswers++;
        }

        /* Initiating toast depending on category and correct answers */
        if ( correctGeographyAnswers > 0 ) {
            Toast toast = Toast.makeText(getApplicationContext(), "You have " + correctGeographyAnswers + " correct answers", Toast.LENGTH_SHORT);
            toast.show();
        } else if( correctArtsAnswers > 0 ) {
            Toast toast = Toast.makeText(getApplicationContext(), "You have " + correctArtsAnswers + " correct answers", Toast.LENGTH_SHORT);
            toast.show();
        }else if( correctHistoryAnswers > 0 ) {
            Toast toast = Toast.makeText(getApplicationContext(), "You have " + correctHistoryAnswers + " correct answers", Toast.LENGTH_SHORT);
            toast.show();
        } else if( correctSportsAnswers > 0 ) {
            Toast toast = Toast.makeText(getApplicationContext(), "You have " + correctSportsAnswers + " correct answers", Toast.LENGTH_SHORT);
            toast.show();
         } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Sorry, no correct answers, try again!", Toast.LENGTH_SHORT);
            toast.show();
        }

        /* Going back to main activity and closing quiz activity */
        finish();
    }
}
