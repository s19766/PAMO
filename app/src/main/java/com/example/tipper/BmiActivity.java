package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class BmiActivity extends AppCompatActivity {

    private Button mainPage, buttonAddToChart;
    private double heightAmount = 0; // height amount entered by the user
    private double weightAmount = 0; // weight amount entered by the user
    private TextView bmiTextView; // shows BMI result
    private TextView heightTextView; // shows height
    private TextView weightTextView; // shows weight
    private String temp_last_bmi_value = "";
    private double total;
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    private int x_index = 0;
    ArrayList barEntries = new ArrayList<BarEntry>(Arrays.asList(
            new BarEntry(x_index++, 30.0f),
            new BarEntry(x_index++, 27.0f),
            new BarEntry(x_index++, 28.0f),
            new BarEntry(x_index++, 25.5f)
    ));

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

        barChart = findViewById(R.id.barchart);
        buttonAddToChart = findViewById(R.id.buttonAddToChart);
        String bmiInitText = "0 BMI";
        bmiTextView.setText(bmiInitText);

        // set heightEditText's TextWatcher
        EditText heightEditView =
                (EditText) findViewById(R.id.heightEditText);
        heightEditView.addTextChangedListener(heightEditTextWatcher);

        // set weightEditText's TextWatcher
        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        updateBmiBarChart();

//        mainPage = findViewById(R.id.returnToMainMenu);

        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonAddToChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (total != 0) {
                    Formatter formatter = new Formatter();
                    formatter.format("%.2f", total);
                    temp_last_bmi_value = formatter.toString();
                    addDataPointAndUpdateBarChart();
                }
            }
        });
    }

    private void addDataPointAndUpdateBarChart(){
        if (temp_last_bmi_value.equals("")){
            return;
        }

        barEntries.add(new BarEntry(x_index, Float.parseFloat(temp_last_bmi_value)));
        x_index++;
        updateBmiBarChart();
    }

    private void updateBmiBarChart(){

        Description desc = new Description();
        desc.setText("");
        barChart.setDescription(desc);

        barDataSet = new BarDataSet(barEntries, "");
        barData = new BarData(barDataSet);
        barChart.setData(barData);

        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);

        barDataSet.setValueTextSize(18f);
        barChart.invalidate();
    }

    // calculate and display BMI
    private void calculate() {
        // calculate the BMI
        double BMI_result = (weightAmount / ((heightAmount / 100) * (heightAmount / 100)));

        // display BMI
        DecimalFormat dfZero = new DecimalFormat("0.00");
        String result = dfZero.format(BMI_result) + " " + "BMI";

        if (total != 0) {
            Formatter formatter = new Formatter();
            formatter.format("%.2f", total);
            temp_last_bmi_value = formatter.toString();
        }

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