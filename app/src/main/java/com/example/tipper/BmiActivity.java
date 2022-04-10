package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {

    private Button mainPage;
    private double heightAmount = 0; // height amount entered by the user
    private double weightAmount = 0; // weight amount entered by the user
    private TextView bmiTextView; // shows BMI result
    private TextView heightTextView; // shows height
    private TextView weightTextView; // shows weight

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_bmi); // inflate the GUI

        // get references to programmatically manipulated TextViews
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        mainPage = findViewById(R.id.returnToMainMenu);

        // set heightEditText's TextWatcher
        EditText heightEditView =
                (EditText) findViewById(R.id.heightEditText);
        heightEditView.addTextChangedListener(heightEditTextWatcher);

        // set weightEditText's TextWatcher
        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        mainPage = findViewById(R.id.returnToMainMenu);

        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    // calculate and display BMI
    private void calculate() {
        // calculate the BMI
        double BMI_result = (weightAmount / ((heightAmount / 100) * (heightAmount / 100)));

        // display BMI
        DecimalFormat dfZero = new DecimalFormat("0.00");
        String result = dfZero.format(BMI_result) + " " + "BMI";
        bmiTextView.setText(result);
    }


    // listener object for the EditText's text-changed events
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        // called when the user modifies the height
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                heightAmount = Integer.parseInt(s.toString());
                String result = heightAmount + " " + "cm";
                heightTextView.setText(result);
            }
            catch (NumberFormatException e) {
                heightTextView.setText("");
                heightAmount = 0;
            }

            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        // called when the user modifies the weight
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                weightAmount = Integer.parseInt(s.toString());
                String result = weightAmount + " " + "kg";
                weightTextView.setText(result);
            }
            catch (NumberFormatException e) {
                weightTextView.setText("");
                weightAmount = 0;
            }

            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };
}