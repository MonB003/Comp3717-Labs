package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    boolean toggle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

    // Called when the button is clicked
    public void BtnToggleClick(View view) {
        // Get a reference to the TextView
        TextView message = findViewById(R.id.textView);

        // Switch between lowercase and uppercase
        if (toggle) {
            message.setText(message.getText().toString().toLowerCase(Locale.ROOT));
        } else {
            message.setText(message.getText().toString().toUpperCase(Locale.ROOT));
        }

        toggle = !toggle;
    }
}