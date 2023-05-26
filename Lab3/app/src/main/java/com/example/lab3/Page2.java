package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
    }


    // Gets the selected check box values
    public ArrayList<String> getSelectedCheckboxes() {
        // Stores check box options
        ArrayList<CheckBox> checkBoxOptions = new ArrayList<>();
        checkBoxOptions.add(findViewById(R.id.business));
        checkBoxOptions.add(findViewById(R.id.relaxation));
        checkBoxOptions.add(findViewById(R.id.medical_reasons));
        checkBoxOptions.add(findViewById(R.id.family_reunification));
        checkBoxOptions.add(findViewById(R.id.others));

        // Stores selected check boxes
        ArrayList<String> checkBoxesSelected = new ArrayList<>();

        // Check if each check box is selected
        for (CheckBox currCheckBox : checkBoxOptions) {
            // If a check box is checked, store it's value in the Arraylist
            if (currCheckBox.isChecked()) {
                String currText = currCheckBox.getText().toString();
                checkBoxesSelected.add(currText);
            }
        }

        // Return the selected check box values
        return checkBoxesSelected;
    }


    // When user clicks the next button
    public void getPage3(View view) {

        // Create a bundle of the page's data
        Bundle bundle = new Bundle();

        // Store the page's data in the bundle to send to the next page
        ArrayList<String> checkBoxesSelected = getSelectedCheckboxes();
        bundle.putStringArrayList("Most Recent Travel Purposes", checkBoxesSelected);

        RatingBar travelRatingBar = findViewById(R.id.travelRatingBar);
        double travelRating = travelRatingBar.getRating();
        bundle.putDouble("Most Recent Travel Rating", travelRating);

        // Extract data from previous page intent
        Intent pageOneIntent = getIntent();
        Bundle pageOneBundle = pageOneIntent.getBundleExtra("bundle");
        String country = pageOneBundle.getString("Country");
        String ageRange = pageOneBundle.getString("Age Range");
        bundle.putString("Country", country);
        bundle.putString("Age Range", ageRange);

        // Create an Intent for the Page3 class
        Intent pageThreeIntent = new Intent(this, Page3.class);
        pageThreeIntent.putExtra("bundle", bundle);

        // Start the intent
        startActivity(pageThreeIntent);
    }
}
