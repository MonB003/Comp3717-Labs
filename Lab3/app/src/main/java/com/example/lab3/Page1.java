package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Page1 extends AppCompatActivity {

    private Spinner countriesSpinner;

    // Default value of spinner is the first country in the text file
    private String selectedSpinnerItem = "Afghanistan";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        try {
            setSpinnerOptions();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Stores spinner object
        countriesSpinner = findViewById(R.id.countriesSpinner);

        // Create a listener every time a spinner item is selected
        countriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // Override the onItemSelected method defined in AdapterView.OnItemSelectedListener
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Store the selected item's value in a string
                selectedSpinnerItem = parent.getItemAtPosition(position).toString();
            }

            // Override the onNothingSelected method defined in AdapterView.OnItemSelectedListener
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    // Set options of the dropdown spinner to each country in countries.txt file
    public void setSpinnerOptions() throws IOException {
        // Stores spinner object
        countriesSpinner = findViewById(R.id.countriesSpinner);

        // Create an ArrayAdapter to store all country options in the spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item);

        // Input stream and buffered reader are used to handle and read the text file
        InputStream inputStream = getBaseContext().getResources().openRawResource(R.raw.countries);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // Read each line in the text file
        String line = "";
        while (line != null) {
            line = bufferedReader.readLine();

            // Store the country in the ArrayAdapter
            arrayAdapter.add(line);
        }

        // Set the ArrayAdapter to the spinner object to add the dropdown options
        countriesSpinner.setAdapter(arrayAdapter);

        bufferedReader.close();
        inputStream.close();
    }


    // When user clicks the next button
    public void getPage2(View view) {
        // Create a bundle of the page's data
        Bundle bundle = new Bundle();
        bundle.putString("Country", selectedSpinnerItem);

        // Get the radio group of buttons
        RadioGroup ageRadioGroup = findViewById(R.id.ageRadioGroup);

        // Find the selected radiobutton ID
        int selectedRadioBtnID = ageRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedRadioBtnID);
        String radioButtonText = radioButton.getText().toString();
        bundle.putString("Age Range", radioButtonText);

        // Create an Intent for the Page2 class
        Intent pageTwoIntent = new Intent(this, Page2.class);
        pageTwoIntent.putExtra("bundle", bundle);

        // Start the intent
        startActivity(pageTwoIntent);
    }
}
