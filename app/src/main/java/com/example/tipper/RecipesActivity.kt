package com.example.tipper

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import android.os.Bundle
import com.example.tipper.R
import android.content.Intent
import com.example.tipper.BmiActivity
import com.example.tipper.CaloriesCalcActivity
import com.example.tipper.RecipesActivity
import com.example.tipper.QuizActivity
import com.example.tipper.Question
import android.annotation.SuppressLint
import android.view.View
import android.widget.*
import com.example.tipper.MainActivity
import java.util.*

class RecipesActivity : AppCompatActivity() {
    private var titleTextView: TextView? = null
    private var foodImageView: ImageView? = null
    private var recipeImageView: ImageView? = null
    private var mainPage: Button? = null
    private val random = Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)
        titleTextView = findViewById(R.id.titleTextView)
        foodImageView = findViewById(R.id.foodImageView)
        recipeImageView = findViewById(R.id.recipeImageView)
        mainPage = findViewById(R.id.backToMainMenu)
        generateView()
        mainPage.setOnClickListener(View.OnClickListener { finish() })
    }

    fun generateView() {
        val upperbound = resources.getInteger(R.integer.upperbound) //random from 0 to 1
        val recipe = random.nextInt(upperbound)
        when (recipe) {
            0 -> {
                titleTextView!!.text = "Eggs"
                foodImageView!!.setImageResource(R.drawable.eggs)
                recipeImageView!!.setImageResource(R.drawable.eggs_recipe)
            }
            1 -> {
                titleTextView!!.text = "Pancakes"
                foodImageView!!.setImageResource(R.drawable.pancakes)
                recipeImageView!!.setImageResource(R.drawable.pancakes_recipe)
            }
        }
    }
}