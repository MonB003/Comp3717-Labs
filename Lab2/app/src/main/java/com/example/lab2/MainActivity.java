package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button changeBackgroundBtn = findViewById(R.id.changeBackgroundBtn);
        // Method to change background when button is clicked
        changeBackgroundBtn.setOnClickListener(view -> {
            ConstraintLayout background = findViewById(R.id.constraintLayout);

            // Create a random colour
            Random numGenerator = new Random();
            int[] rgbColours = new int[3];
            rgbColours[0] = numGenerator.nextInt(255);
            rgbColours[1] = numGenerator.nextInt(255);
            rgbColours[2] = numGenerator.nextInt(255);

            // Change background to random colour
            background.setBackgroundColor(Color.rgb(rgbColours[0], rgbColours[1], rgbColours[2]));
        });


        // Method to get api version when button is clicked
        Button apiVersionBtn = findViewById(R.id.apiVersionBtn);
        apiVersionBtn.setOnClickListener(view -> {
            // Get this device's version details
            String manufacturer = android.os.Build.MANUFACTURER;
            String model = android.os.Build.MODEL;
            int version = android.os.Build.VERSION.SDK_INT;
            String versionRelease = android.os.Build.VERSION.RELEASE;
            String messageText = " manufacturer " + manufacturer + " \n model "
                    + model + " \n version " + version + " \n versionRelease " + versionRelease;

            // Create Toast object
            Toast toastMessage = Toast.makeText(getApplicationContext(), messageText, Toast.LENGTH_SHORT);
            // Change message text colour to red
            TextView textView = toastMessage.getView().findViewById(android.R.id.message);
            textView.setTextColor(Color.RED);
            toastMessage.show();
        });


        // Method to get serial number when button is clicked
        Button serialNumberBtn = findViewById(R.id.serialNumberBtn);
        serialNumberBtn.setOnClickListener(view -> {
            // Get the current device's ID
            String deviceId = Settings.System.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

            // Create intent to store serial number information
            Intent serialNumIntent = new Intent();
            serialNumIntent.setAction(Intent.ACTION_SEND);
            serialNumIntent.putExtra(Intent.EXTRA_TEXT, deviceId);
            serialNumIntent.setType("text/plain");

            // Show the intent
            Intent broadcastIntent = Intent.createChooser(serialNumIntent, null);
            startActivity(broadcastIntent);
        });
    }


    // When user clicks the Text to Speech button
    public void getSpeakActivity(View view) {
        // Create an Intent for the SpeakActivity class
        Intent speakIntent = new Intent(this, SpeakActivity.class);

        // Start the intent
        startActivity(speakIntent);
    }

}