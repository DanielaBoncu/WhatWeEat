package ro.whatweeat.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import ro.whatweeat.R;

public class EatOrCook extends AppCompatActivity {
    private Button takeOut;
    private Button recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_or_cook);
        Uri takeOutWebPage = Uri.parse("https://glovoapp.com/ro/");
        Uri recipeWebPage = Uri.parse("https://www.google.com/search?client=firefox-b-d&q=retete+burgeri");
        takeOut = findViewById(R.id.button_take_out);
        takeOut.setOnClickListener(v -> {
            Intent takeOutIntent = new Intent(Intent.ACTION_VIEW, takeOutWebPage);
            startActivity(takeOutIntent);
        });
        recipe = findViewById(R.id.button_recipe);
        recipe.setOnClickListener(v -> {
            Intent recipeIntent = new Intent(Intent.ACTION_VIEW, recipeWebPage);
            startActivity(recipeIntent);
        });

    }
}