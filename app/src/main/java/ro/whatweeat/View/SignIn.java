package ro.whatweeat.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import ro.whatweeat.R;

public class SignIn extends AppCompatActivity {
    private Button loginButton;
    private EditText mLastName, mFirstName, mEmail, mAddress, mPhoneNo, mPassword;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        loginButton = findViewById(R.id.buttonLogin);
        mLastName = findViewById(R.id.editTextLastName);
        mFirstName = findViewById(R.id.editTextFirstName);
        mPhoneNo = findViewById(R.id.editTextPhoneNumber);
        mAddress = findViewById(R.id.editTextAddress);
        mEmail = findViewById(R.id.editTextEmailAddress);
        mPassword = findViewById(R.id.editTextPassword);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            Intent goToMenu = new Intent(SignIn.this, Menu.class);
            startActivity(goToMenu);
            finish();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastName = mLastName.getText().toString();
                String firstName = mFirstName.getText().toString();
                String phoneNo = mPhoneNo.getText().toString();
                String address = mAddress.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email necesar!");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Parola necesara!");
                    return;
                }
                if(password.length() < 6){
                    mPassword.setError("Parola trebuie sa aiba mai mult de 6 caractere!");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignIn.this, "Cont creat.", Toast.LENGTH_SHORT).show();
                            Intent goToMenu = new Intent(SignIn.this, Menu.class);
                            startActivity(goToMenu);
                        }else{
                            Toast.makeText(SignIn.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

}