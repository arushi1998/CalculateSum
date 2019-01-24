package com.example.arush.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Game extends AppCompatActivity {

    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer, score =0, numberOfQuestions = 0;
    TextView pointsTextView, sumTextView, timerTextView;
    Button button0, button1, button2, button3;
    LinearLayout linearLayout;

    public void generateQuestion() {

        answers.clear();

        Random rand = new Random();
        // for a random number between 0 and 50
        int a = rand.nextInt(51);
        int b = rand.nextInt(51);

        sumTextView.setText(Integer.toString(a) + "\n     +\n        " + Integer.toString(b));
        locationOfCorrectAnswer = rand.nextInt(4);
        int incorrectAnswer;

        for (int i=0; i<4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            } else {
                incorrectAnswer = rand.nextInt(101);

                while (incorrectAnswer == a + b) {

                    incorrectAnswer = rand.nextInt(101);
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void chooseAnswer(View view) {

        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
            score++;
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));

        generateQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        sumTextView = findViewById(R.id.sumTextView);
        timerTextView = findViewById(R.id.timerTextView);
        pointsTextView = findViewById(R.id.pointsTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout.setVisibility(View.INVISIBLE);

        playAgain(findViewById(R.id.linearLayout));
    }

    public void playAgain (View view) {
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        linearLayout.setVisibility(View.INVISIBLE   );

        generateQuestion();

        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                timerTextView.setText("0s");
                linearLayout.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void back(View view) {

        finish();
        System.exit(0);
    }
}
