package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.util.Log;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    // Stores the Show Message button
    Button messageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // When app is opened for the first time
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Android", "This is an onCreate event!");

        messageButton = findViewById(R.id.button);
        // Method when show message button is clicked
        messageButton.setOnClickListener(view -> {

            // Store the message text and text field input
            TextView welcomeMessage = findViewById(R.id.welcomeMessage);
            EditText nameInput = findViewById(R.id.nameEditText);

            // Stores the song based on whether the text input is empty or not
            MediaPlayer songPlayer;

            // Check if the text input field is empty
            if (nameInput.getText().toString().trim().isEmpty()) {
                // Display error message
                String emptyNameMessage = "You must enter a name.";
                welcomeMessage.setText(emptyNameMessage);
                // Change message colour
                welcomeMessage.setTextColor(Color.RED);
                // Play empty name mp3 song
                songPlayer = MediaPlayer.create(this, R.raw.empty_name);

            } else {
                // Get 3 random numbers to create a random rgb colour
                Random numGenerator = new Random();
                int[] rgbColours = new int[3];
                rgbColours[0] = numGenerator.nextInt(255);
                rgbColours[1] = numGenerator.nextInt(255);
                rgbColours[2] = numGenerator.nextInt(255);

                // Display user's name
                String userNameMessage = "Hello, " + nameInput.getText() + "!";
                welcomeMessage.setText(userNameMessage);
                // Change text to random colour
                welcomeMessage.setTextColor(Color.rgb(rgbColours[0], rgbColours[1], rgbColours[2]));
                // Play non empty name mp3 song
                songPlayer = MediaPlayer.create(this, R.raw.nonempty_name);
            }

            // Starts playing the song after button is clicked
            songPlayer.start();
        });
    }

    @Override
    protected void onStart() {
        // After create method is called, when app is opened
        super.onStart();
        Log.d("Android", "This is an onStart event!");
    }

    @Override
    protected void onResume() {
        // After start method, when app is opened again
        super.onResume();
        Log.d("Android", "This is an onResume event!");
    }

    @Override
    protected void onPause() {
        // When app is closed
        super.onPause();
        Log.d("Android", "This is an onPause event!");
    }

    @Override
    protected void onStop() {
        // When app is closed, after pause method is called
        super.onStop();
        Log.d("Android", "This is an onStop event!");
    }

    @Override
    protected void onRestart() {
        // When app is reopened after having been stopped from running
        super.onRestart();
        Log.d("Android", "This is an onRestart event!");
    }

    @Override
    protected void onDestroy() {
        // When app is no longer running
        super.onDestroy();
        Log.d("Android", "This is an onDestroy event!");
    }

}