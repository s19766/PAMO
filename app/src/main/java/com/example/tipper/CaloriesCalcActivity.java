package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import java.util.Objects;

public class CaloriesCalcActivity extends AppCompatActivity {

    private Button female, male, calculate, mainPage;
    private TextInputLayout inputHeightLayout, inputWeightLayout, inputAgeLayout;
    private TextView result;
    private float weight, height, calories;
    private int age;
    private String gender;

    private final DecimalFormat df = new DecimalFormat("#.##");
    private String formatted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_calc);

        female = findViewById(R.id.chooseFemale);
        male = findViewById(R.id.chooseMale);

        calculate = findViewById(R.id.calculateCalories);
        mainPage = findViewById(R.id.returnToMainMenu);

        inputHeightLayout = findViewById(R.id.inputHeightLayout);
        inputWeightLayout = findViewById(R.id.inputWeightLayout);
        inputAgeLayout = findViewById(R.id.inputAgeLayout);

        result = findViewById(R.id.showResult);

        mainPage = findViewById(R.id.returnToMainMenu);

        //set default gender
        gender = "female";
        female.setEnabled(false);

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gender.equals("female")) {
                    female.setEnabled(false);
                } else {
                    gender = "female";
                    female.setEnabled(false);
                    male.setEnabled(true);
                }
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gender.equals("male")) {
                    male.setEnabled(false);
                } else {
                    gender = "male";
                    male.setEnabled(false);
                    female.setEnabled(true);
                }
            }

        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResult();
            }
        });

        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getResult() {
        height = Float.parseFloat(Objects.requireNonNull(inputHeightLayout.getEditText()).getText().toString().trim());
        weight = Float.parseFloat(Objects.requireNonNull(inputWeightLayout.getEditText()).getText().toString().trim());
        age = Integer.parseInt(Objects.requireNonNull(inputAgeLayout.getEditText()).getText().toString().trim());

        if(gender != null) {
            switch (gender) {
                case ("male"): {
                    calories = 66.47f + (13.7f * weight) + (5.0f * height) - (6.76f * age);
                    formatted = df.format(calories);
                    result.setText(formatted);
                    break;
                }
                case ("female"): {
                    calories = 655.1f + (9.567f * weight) + (1.85f * height) - (4.68f * age);
                    formatted = df.format(calories);
                    result.setText(formatted);
                    break;
                }
            }
        } else
            Toast.makeText(getApplicationContext(), "Choose gender!", Toast.LENGTH_SHORT).show();
    }
}