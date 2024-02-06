package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class DecryptActivity extends AppCompatActivity {
    EditText editTextInput;
    Button button;
    EditText editTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        editTextInput = findViewById(R.id.editTextInput);
        button = findViewById(R.id.button);
        editTextResult = findViewById(R.id.editTextResult);

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        boolean isDateEven = (dayOfMonth % 2 == 0);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from editTextInput
                String inputText = editTextInput.getText().toString();

                int key = 3;
                // Perform your string operation here

                if (isDateEven) {
                    String resultText = performStringOperationw(inputText,key);
                    // Display the result in editTextResult
                    editTextResult.setText(resultText);
                } else {
                    String resultText = performStringOperation(inputText,key);
                    // Display the result in editTextResult
                    editTextResult.setText(resultText);
                }




            }
        });

    }
    private String performStringOperation(String input, int key) {
        StringBuilder result = new StringBuilder();

//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            // Check if the character is an uppercase letter
//            if (Character.isUpperCase(c)) {
//                char shiftedChar = (char) (((c - 'A' + key) % 26) + 'A');
//                result.append(shiftedChar);
//            }
//            // Check if the character is a lowercase letter
//            else if (Character.isLowerCase(c)) {
//                char shiftedChar = (char) (((c - 'a' + key) % 26) + 'a');
//                result.append(shiftedChar);
//            }
//            // If the character is not a letter, leave it unchanged
//            else {
//                result.append(c);
//            }
//        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Decrement the primary code by 2
            char modifiedChar = (char) (c - 2);
            result.append(modifiedChar);
        }

        return result.toString();

    }

    private String performStringOperationw(String input, int key) {
        StringBuilder result = new StringBuilder();

//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            // Check if the character is an uppercase letter
//            if (Character.isUpperCase(c)) {
//                char shiftedChar = (char) (((c - 'A' + key) % 26) + 'A');
//                result.append(shiftedChar);
//            }
//            // Check if the character is a lowercase letter
//            else if (Character.isLowerCase(c)) {
//                char shiftedChar = (char) (((c - 'a' + key) % 26) + 'a');
//                result.append(shiftedChar);
//            }
//            // If the character is not a letter, leave it unchanged
//            else {
//                result.append(c);
//            }
//        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Decrement the primary code by 2
            char modifiedChar = (char) (c - 3);
            result.append(modifiedChar);
        }

        return result.toString();

    }
}