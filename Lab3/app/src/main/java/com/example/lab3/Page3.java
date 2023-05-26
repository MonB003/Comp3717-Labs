package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Page3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        // Display all values from the text from the previous pages data
        displaySummaryText();
    }


    // Get text values from page data responses
    public void displaySummaryText() {
        // Get textViews on the page
        TextView countryTextView = findViewById(R.id.countryTextView);
        TextView ageTextView = findViewById(R.id.ageTextView);
        TextView purposeTextView = findViewById(R.id.purposeTextView);
        TextView ratingTextView = findViewById(R.id.ratingTextView);

        // Get the intent
        Intent pagesIntent = getIntent();

        // Extract data from the bundle and store the values in string objects to display
        Bundle pagesBundle = pagesIntent.getBundleExtra("bundle");
        String country = pagesBundle.getString("Country");
        String ageRange = pagesBundle.getString("Age Range");
        ArrayList<String> travelPurposesList = pagesBundle.getStringArrayList("Most Recent Travel Purposes");
        double travelRating = pagesBundle.getDouble("Most Recent Travel Rating");
        String ratingString = String.valueOf(travelRating);

        // Set the values of the text view objects to the bundle result for each question
        countryTextView.append("\n" + country);
        ageTextView.append("\n" +ageRange);
        ratingTextView.append("\n" +ratingString);

        // Create a StringBuilder to store all check box options from the Arraylist in the bundle
        StringBuilder travelPurposes = new StringBuilder();
        for (String purpose : travelPurposesList) {
            travelPurposes.append(purpose).append("\n");
        }
        purposeTextView.append("\n" + travelPurposes);
    }


    // When user clicks the submit button
    public void getPage4(View view) {
        // Create an Intent for the Page4 class
        Intent pageFourIntent = new Intent(this, Page4.class);

        // Start the intent
        startActivity(pageFourIntent);
    }
}
