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
import com.example.tipper.MainActivity

class Question internal constructor(
    _question: String,
    _answers: Array<String?>,
    _correctAnswer: Int
) {
    var question = ""
    var answers: Array<String?>
    var correctAnswer = -1

    init {
        question = _question
        answers = _answers
        correctAnswer = _correctAnswer
    }
}