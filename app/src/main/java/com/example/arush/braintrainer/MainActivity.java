package com.example.arush.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void rules(View view) {
        Intent rulesIntent = new Intent(this, Instructions.class);
        startActivity(rulesIntent);
    }

    public void start (View view) {
        Intent startIntent = new Intent(this, Game.class);
        startActivity(startIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
