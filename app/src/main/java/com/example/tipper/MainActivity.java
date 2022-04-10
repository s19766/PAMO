//Damian Eggert s19766
package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goBmi, goCalories, goRecipes;

        goBmi = findViewById(R.id.bmiButton);
        goCalories = findViewById(R.id.caloriesButton);
        goRecipes = findViewById(R.id.recipesButton);

        goBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBmiCalculator();
            }
        });

        goCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCaloriesCalculator();
            }
        });

        goRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchGetReceip();
            }
        });
    }

    private void launchBmiCalculator() {
        Intent intent = new Intent(this, BmiActivity.class);
        startActivity(intent);
    }

    private void launchCaloriesCalculator() {
        Intent intent = new Intent(this, CaloriesCalcActivity.class);
        startActivity(intent);
    }

    private void launchGetReceip() {
        Intent intent = new Intent(this, RecipesActivity.class);
        startActivity(intent);
    }
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
