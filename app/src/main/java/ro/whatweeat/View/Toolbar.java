package ro.whatweeat.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import ro.whatweeat.R;

public class Toolbar extends AppCompatActivity {

    private ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menuButton = findViewById(R.id.button_menu);
        menuButton.setOnClickListener(v -> {
            Intent goToAlone = new Intent(Toolbar.this, Nav.class);
            startActivity(goToAlone);
        });
    }
}
