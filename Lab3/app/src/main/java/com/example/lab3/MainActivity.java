package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // When start button is clicked
        Button startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(view -> {
            EditText codeInput = findViewById(R.id.enterCodeInput);
            String codeInputString = codeInput.getText().toString();

            // Check if input matches the code
            if (codeInputString.equalsIgnoreCase("COMP3717")) {
                // Go to the first page activity
                getPage1(view);

            } else {
                // Create Toast object to show error message
                String errorMessage = "WRONG CODE";
                Toast toastMessage = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT);
                toastMessage.show();
            }
        });
    }


    // When user clicks the start button
    public void getPage1(View view) {
        // Create an Intent for the Page1 class
        Intent pageOneIntent = new Intent(this, Page1.class);

        // Start the intent
        startActivity(pageOneIntent);
    }


}