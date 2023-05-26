package com.example.lab4;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConstraintLayoutForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        Button btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setBackgroundColor(Color.DKGRAY);
    }
}
