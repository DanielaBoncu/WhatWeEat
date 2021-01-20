package ro.whatweeat.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import ro.whatweeat.R;

public class SignIn extends AppCompatActivity {
    private Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        menuButton = findViewById(R.id.buttonLogin);
        menuButton.setOnClickListener(v -> {
            Intent goToMenu = new Intent(SignIn.this, Menu.class);
            startActivity(goToMenu);
        });
    }

}