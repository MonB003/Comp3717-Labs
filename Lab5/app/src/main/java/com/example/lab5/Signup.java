package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        FirebaseApp.initializeApp(this);

        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(view -> backBtnClicked());


        EditText firstNameInput = findViewById(R.id.firstName);
        EditText lastNameInput = findViewById(R.id.lastName);
        EditText usernameInput = findViewById(R.id.username);
        EditText emailInput = findViewById(R.id.userEmail);
        EditText passwordInput = findViewById(R.id.userPassword);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");

//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference("User");
//        FirebaseApp.initializeApp(this);

        user = new User();

//        Button signupBtn = findViewById(R.id.signupBtn);
//        signupBtn.setOnClickListener(view -> {
//            String firstName = firstNameInput.getText().toString();
//            String lastName = lastNameInput.getText().toString();
//            String username = usernameInput.getText().toString();
//            String email = emailInput.getText().toString();
//            String password = passwordInput.getText().toString();
//
//            writeUserToFirebase(firstName, lastName, username, email, password);
//        });
    }


    private void writeUserToFirebase(String firstName, String lastName, String username, String email, String password) {
        // Store input field values into user object
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        // we are use add value event listener method
        // which is called with database reference.
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                databaseReference.setValue(user);
//                Toast.makeText(Signup.this, "data added", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(Signup.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    public void backBtnClicked() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}