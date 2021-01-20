package ro.whatweeat.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import ro.whatweeat.R;

public class Alone extends AppCompatActivity {
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alone);
        saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(v -> {
            Intent goToEatOrCook = new Intent(Alone.this, EatOrCook.class);
            startActivity(goToEatOrCook);
        });
    }
}