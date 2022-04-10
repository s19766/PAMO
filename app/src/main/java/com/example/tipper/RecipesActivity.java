package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class RecipesActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ImageView foodImageView, recipeImageView;
    private Button mainPage;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        titleTextView = findViewById(R.id.titleTextView);
        foodImageView = findViewById(R.id.foodImageView);
        recipeImageView = findViewById(R.id.recipeImageView);
        mainPage = findViewById(R.id.backToMainMenu);

        generateView();

        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void generateView() {
        final int upperbound = getResources().getInteger(R.integer.upperbound); //random from 0 to 1
        int recipe = random.nextInt(upperbound);
        switch (recipe) {
            case 0: {
                titleTextView.setText("Eggs");
                foodImageView.setImageResource(R.drawable.eggs);
                recipeImageView.setImageResource(R.drawable.eggs_recipe);
                break;
            } case 1: {
                titleTextView.setText("Pancakes");
                foodImageView.setImageResource(R.drawable.pancakes);
                recipeImageView.setImageResource(R.drawable.pancakes_recipe);
                break;
            }
        }
    }
}