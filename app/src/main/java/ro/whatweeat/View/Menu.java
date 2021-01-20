package ro.whatweeat.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import ro.whatweeat.R;

public class Menu extends AppCompatActivity {
    private Button aloneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        aloneButton = findViewById(R.id.button_alone);
        aloneButton.setOnClickListener(v -> {
            Intent goToAlone = new Intent(Menu.this, Alone.class);
            startActivity(goToAlone);
        });
    }

    public void logOut(View view){
        FirebaseAuth.getInstance().signOut();
        Intent goToLogin = new Intent(Menu.this, Login.class);
        startActivity(goToLogin);
        finish();
    }

}