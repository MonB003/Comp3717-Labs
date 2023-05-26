package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(view -> {
            Intent loginIntent = new Intent(this, Login.class);
            startActivity(loginIntent);
        });

        Button signupBtn = findViewById(R.id.signupBtn);
        signupBtn.setOnClickListener(view -> {
            Intent signupIntent = new Intent(this, Signup.class);
            startActivity(signupIntent);
        });
    }
}