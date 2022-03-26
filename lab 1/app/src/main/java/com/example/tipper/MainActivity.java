package com.example.tipper;

import java.text.DecimalFormat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText; // for bill amount input
import android.widget.TextView; // for displaying text

public class MainActivity extends AppCompatActivity {

    private double heightAmount = 0; // height amount entered by the user
    private double weightAmount = 0; // weight amount entered by the user
    private TextView bmiTextView; // shows BMI result
    private TextView heightTextView; // shows height
    private TextView weightTextView; // shows weight

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_main); // inflate the GUI

        // get references to programmatically manipulated TextViews
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        weightTextView = (TextView) findViewById(R.id.weightTextView);

        // set heightEditText's TextWatcher
        EditText heightEditView =
                (EditText) findViewById(R.id.heightEditText);
        heightEditView.addTextChangedListener(heightEditTextWatcher);

        // set weightEditText's TextWatcher
        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

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


/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
