package ro.whatweeat.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ro.whatweeat.R;

public class Login extends AppCompatActivity {
    private Button signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInButton = findViewById(R.id.buttonSignIn);
        signInButton.setOnClickListener(v -> {
            Intent goToSignIn = new Intent(Login.this, SignIn.class);
            startActivity(goToSignIn);
        });
    }

}
