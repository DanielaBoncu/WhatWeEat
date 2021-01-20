package ro.whatweeat.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ro.whatweeat.R;

public class Login extends AppCompatActivity {
    private Button signInButton, loginButton;
    private EditText mEmail, mPassword;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInButton = findViewById(R.id.buttonSignIn);
        loginButton = findViewById(R.id.buttonLogin);
        mEmail = findViewById(R.id.editTextEmailAddress);
        mPassword = findViewById(R.id.editTextPassword);

        fAuth = FirebaseAuth.getInstance();
        signInButton.setOnClickListener(v -> {
            Intent goToSignIn = new Intent(Login.this, SignIn.class);
            startActivity(goToSignIn);
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email necesar!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Parola necesara!");
                    return;
                }
                if (password.length() < 6) {
                    mPassword.setError("Parola trebuie sa aiba mai mult de 6 caractere!");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent goToMenu = new Intent(Login.this, Menu.class);
                            startActivity(goToMenu);
                        } else {
                            Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

}
