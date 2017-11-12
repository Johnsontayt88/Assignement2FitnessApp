package com.example.johnsontay.assignement2fitnessapp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView status = (TextView) findViewById(R.id.textViewStatus);
        final EditText editTextWeight = (EditText) findViewById(R.id.Weight);
        final EditText editTextHeight = (EditText) findViewById(R.id.Height);
        Button button = (Button) findViewById(R.id.buttonCheck);

        final MediaPlayer soundObese = MediaPlayer.create(this, R.raw.obese);
        final MediaPlayer soundOverweight = MediaPlayer.create(this, R.raw.overweight);
        final MediaPlayer soundNormalweight = MediaPlayer.create(this, R.raw.normal);
        final MediaPlayer soundUnderweight = MediaPlayer.create(this, R.raw.underweight);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight = Double.parseDouble(editTextWeight.getText().toString());
                double height = Double.parseDouble(editTextHeight.getText().toString());
                double bmi = weight / (height * height);

                String statusText;
                int statusColor;

                if (bmi > 27.5) {
                    statusText = "Your BMI Is : Obese!";
                    statusColor = Color.RED;
                    soundObese.start();
                    Toast.makeText(getApplicationContext(), "obese", Toast.LENGTH_SHORT).show();
                } else if (bmi > 23) {
                    statusText = "Your BMI Is : Your Are Overweight!";
                    statusColor = Color.YELLOW;
                    soundOverweight.start();
                } else if (bmi > 18.5) {
                    statusText = "Your BMI Is : Your weight is ideal!";
                    statusColor = Color.GREEN;
                    soundNormalweight.start();
                } else {
                    statusText = "Your BMI Is : You Are Underweight!";
                    statusColor = Color.WHITE;
                    soundUnderweight.start();
                }

                status.setText(statusText);
                status.setBackgroundColor(statusColor);
            }
        });
    }
}