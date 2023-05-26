package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button generateJsonBtn;
    Button calculateBtn;
    EditText editTextNumber1;
    EditText editTextNumber2;
    EditText editTextAddition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextAddition = findViewById(R.id.editTextAddition);

        generateJsonBtn = findViewById(R.id.btnGenerate);
        generateJsonBtn.setOnClickListener(view -> {
            String number1Str = editTextNumber1.getText().toString();
            String number2Str = editTextNumber2.getText().toString();
            Integer number1 = Integer.parseInt(number1Str);
            Integer number2 = Integer.parseInt(number2Str);

            JSONObject jsonObject = new JSONObject();

            try {
                JSONObject jsonNumbers = new JSONObject();
                jsonNumbers.put("a", number1);
                jsonNumbers.put("b", number2);

                JSONObject jsonAdd = new JSONObject();
                jsonAdd.put("add", jsonNumbers);

                jsonObject.put("operation", jsonAdd);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            String jsonString = jsonObject.toString();
            String jsonFormatted = formatJSON(jsonString);
            editTextAddition.setText(jsonFormatted);
        });


        calculateBtn = findViewById(R.id.btnCalculate);
        calculateBtn.setOnClickListener(view -> {
            String jsonString = editTextAddition.getText().toString();
            try {
                JSONObject jsonEditText = new JSONObject(jsonString);
                Object operation = jsonEditText.get("operation");

                JSONObject jsonAdd = new JSONObject(operation.toString());
                Object add = jsonAdd.get("add");

                JSONObject jsonNumbers = new JSONObject(add.toString());
                Object object1 = jsonNumbers.get("a");
                Object object2 = jsonNumbers.get("b");

                Integer number1 = (Integer) object1;
                Integer number2 = (Integer) object2;
                int sum = number1 + number2;

                String calculateResult = "The sum of " + object1 + " and " + object2 + " is " + sum + "!";

                Toast toast = Toast.makeText(getApplicationContext(), calculateResult, Toast.LENGTH_LONG);
                toast.show();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * Formats a JSON string in multiple lines with indentation.
     * @param jsonString: string of a JSON object
     * @return indentedString: formatted and indented string of the parameter string
     */
    private static String formatJSON(String jsonString) {
        StringBuilder jsonFormatted = new StringBuilder("{\n");
        int[] numTabs = {0, 1, 2, 3, 3, 2, 1, 0};
        int currTabCount = 0;

        // Loop through each character in the string
        for (int index = 1; index < jsonString.length(); index++) {
            char currChar = jsonString.charAt(index);

            // Add appropriate new lines depending on the character
            if (currChar == '}') {
                jsonFormatted.append("\n");
                jsonFormatted.append(currChar);
            } else if ((currChar == '"')) {
                jsonFormatted.append(currChar);
            } else if (currChar == ',') {
                jsonFormatted.append(currChar);
                jsonFormatted.append("\n");
            } else if (currChar == ':') {
                jsonFormatted.append(" : ");
            } else if ((currChar == '{') && (jsonString.charAt(index-1) == ':')) {
                jsonFormatted.append(currChar);
                jsonFormatted.append("\n");
            } else {
                jsonFormatted.append(currChar);
            }
        }

        String[] jsonStrArray = jsonFormatted.toString().split("\n");
        StringBuilder indentedString = new StringBuilder();

        for (String string : jsonStrArray) {
            // Add spaces for indentation
            for (int i = 0; i < numTabs[currTabCount]; i++) {
                indentedString.append(" ");
            }
            indentedString.append(string);
            indentedString.append("\n");
            currTabCount++;
        }

        return indentedString.toString();
    }
}