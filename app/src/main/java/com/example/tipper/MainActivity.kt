//Damian Eggert s19766
package com.example.tipper

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import android.widget.TextView
import android.os.Bundle
import com.example.tipper.R
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import com.example.tipper.BmiActivity
import com.example.tipper.CaloriesCalcActivity
import com.example.tipper.RecipesActivity
import com.example.tipper.QuizActivity
import com.example.tipper.Question
import android.annotation.SuppressLint
import android.widget.Button
import com.example.tipper.MainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val goBmi: Button
        val goCalories: Button
        val goRecipes: Button
        val goQuiz: Button
        goBmi = findViewById(R.id.bmiButton)
        goCalories = findViewById(R.id.caloriesButton)
        goRecipes = findViewById(R.id.recipesButton)
        goQuiz = findViewById(R.id.goQuiz)
        goBmi.setOnClickListener { launchBmiCalculator() }
        goCalories.setOnClickListener { launchCaloriesCalculator() }
        goRecipes.setOnClickListener { launchGetReceip() }
        goQuiz.setOnClickListener { launchQuiz() }
    }

    private fun launchBmiCalculator() {
        val intent = Intent(this, BmiActivity::class.java)
        startActivity(intent)
    }

    private fun launchCaloriesCalculator() {
        val intent = Intent(this, CaloriesCalcActivity::class.java)
        startActivity(intent)
    }

    private fun launchGetReceip() {
        val intent = Intent(this, RecipesActivity::class.java)
        startActivity(intent)
    }

    private fun launchQuiz() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}