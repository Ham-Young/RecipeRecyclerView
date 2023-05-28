package com.example.reciperecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);


        ImageView recipeImageView = findViewById(R.id.recipeImageView);

        TextView recipeTextView = findViewById(R.id.recipeDetial);

       ImageView imageBack=findViewById(R.id.imag_back);
       imageBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("recipeDetial")) {
            String recipeText = intent.getStringExtra("recipeDetial");
            int recipeImageResId=intent.getIntExtra("recipeImageResId",0);
            recipeImageView.setImageResource(recipeImageResId);
            recipeTextView.setText(recipeText);

        }




    }
}