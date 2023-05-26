package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class SpeakActivity extends AppCompatActivity {

    TextToSpeech speechObject;
    Button speakBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak_activity);

        // Get the intent
        getIntent();

        // Set text to speech object language
        speechObject = new TextToSpeech(getApplicationContext(), status -> {
            if(status != TextToSpeech.ERROR) {
                speechObject.setLanguage(Locale.ENGLISH);
            }
        });

        // When speak button is clicked
        speakBtn = findViewById(R.id.speakBtn);
        speakBtn.setOnClickListener(view -> {
            // Get text input
            EditText enterTextInput = findViewById(R.id.enterTextInput);
            String textInput = enterTextInput.getText().toString();
            Toast.makeText(getApplicationContext(), textInput,Toast.LENGTH_SHORT).show();
            // Get object to speak the text
            speechObject.speak(textInput, TextToSpeech.QUEUE_FLUSH, savedInstanceState, null);
        });
    }


    // When user clicks the back button, redirect back to MainActivity page
    public void getMainActivity(View view) {
        // Create an Intent for the MainActivity class
        Intent mainIntent = new Intent(this, MainActivity.class);

        // Start the intent
        startActivity(mainIntent);
    }
}
