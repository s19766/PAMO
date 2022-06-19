package com.example.tipper

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import android.os.Bundle
import com.example.tipper.R
import android.widget.EditText
import com.github.mikephil.charting.utils.ColorTemplate
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.Button
import com.github.mikephil.charting.components.Description
import java.text.DecimalFormat
import java.util.*

class BmiActivity : AppCompatActivity() {
    private var mainPage: Button? = null
    private var buttonAddToChart: Button? = null
    private var heightAmount = 0.0 // height amount entered by the user
    private var weightAmount = 0.0 // weight amount entered by the user
    private var bmiTextView // shows BMI result
            : TextView? = null
    private var heightTextView // shows height
            : TextView? = null
    private var weightTextView // shows weight
            : TextView? = null
    private var temp_last_bmi_value = ""
    private val total = 0.0
    var barChart: BarChart? = null
    var barData: BarData? = null
    var barDataSet: BarDataSet? = null
    private var x_index = 0
    var barEntries: ArrayList<*> = ArrayList<BarEntry>(
        Arrays.asList(
            BarEntry(x_index++, 30.0f),
            BarEntry(x_index++, 27.0f),
            BarEntry(x_index++, 28.0f),
            BarEntry(x_index++, 25.5f)
        )
    )

    // called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call superclass onCreate
        setContentView(R.layout.activity_bmi) // inflate the GUI

        // get references to programmatically manipulated TextViews
        bmiTextView = findViewById<View>(R.id.bmiTextView) as TextView
        heightTextView = findViewById<View>(R.id.heightTextView) as TextView
        weightTextView = findViewById<View>(R.id.weightTextView) as TextView
        mainPage = findViewById(R.id.returnToMainMenu)
        barChart = findViewById(R.id.barchart)
        buttonAddToChart = findViewById(R.id.buttonAddToChart)
        val bmiInitText = "0 BMI"
        bmiTextView!!.text = bmiInitText

        // set heightEditText's TextWatcher
        val heightEditView = findViewById<View>(R.id.heightEditText) as EditText
        heightEditView.addTextChangedListener(heightEditTextWatcher)

        // set weightEditText's TextWatcher
        val weightEditText = findViewById<View>(R.id.weightEditText) as EditText
        weightEditText.addTextChangedListener(weightEditTextWatcher)
        updateBmiBarChart()

//        mainPage = findViewById(R.id.returnToMainMenu);
        mainPage.setOnClickListener(View.OnClickListener { finish() })
        buttonAddToChart.setOnClickListener(View.OnClickListener {
            if (total != 0.0) {
                val formatter = Formatter()
                formatter.format("%.2f", total)
                temp_last_bmi_value = formatter.toString()
                addDataPointAndUpdateBarChart()
            }
        })
    }

    private fun addDataPointAndUpdateBarChart() {
        if (temp_last_bmi_value == "") {
            return
        }
        barEntries.add(BarEntry(x_index, temp_last_bmi_value.toFloat()))
        x_index++
        updateBmiBarChart()
    }

    private fun updateBmiBarChart() {
        val desc = Description()
        desc.text = ""
        barChart!!.description = desc
        barDataSet = BarDataSet(barEntries, "")
        barData = BarData(barDataSet)
        barChart!!.data = barData
        barDataSet!!.setColors(*ColorTemplate.JOYFUL_COLORS)
        barDataSet!!.valueTextColor = Color.BLACK
        barDataSet!!.valueTextSize = 18f
        barChart!!.invalidate()
    }

    // calculate and display BMI
    private fun calculate() {
        // calculate the BMI
        val BMI_result = weightAmount / (heightAmount / 100 * (heightAmount / 100))

        // display BMI
        val dfZero = DecimalFormat("0.00")
        val result = dfZero.format(BMI_result) + " " + "BMI"
        if (total != 0.0) {
            val formatter = Formatter()
            formatter.format("%.2f", total)
            temp_last_bmi_value = formatter.toString()
        }
        bmiTextView!!.text = result
    }

    // listener object for the EditText's text-changed events
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the height
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                heightAmount = s.toString().toInt().toDouble()
                val result = "$heightAmount cm"
                heightTextView!!.text = result
            } catch (e: NumberFormatException) {
                heightTextView!!.text = ""
                heightAmount = 0.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the weight
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                weightAmount = s.toString().toInt().toDouble()
                val result = "$weightAmount kg"
                weightTextView!!.text = result
            } catch (e: NumberFormatException) {
                weightTextView!!.text = ""
                weightAmount = 0.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
}