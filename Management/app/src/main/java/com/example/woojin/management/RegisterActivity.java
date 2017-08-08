package com.example.woojin.management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    EditText idText;
    EditText passwordText;
    EditText nameText;
    EditText ageText;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idText = (EditText)findViewById(R.id.idText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        nameText = (EditText)findViewById(R.id.nameText);
        ageText = (EditText)findViewById(R.id.ageText);
        registerButton = (Button)findViewById(R.id.registerButton);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String userId = idText.getText().toString();
                String password = passwordText.getText().toString();
                String userName = nameText.getText().toString();
                String userAge = ageText.getText().toString();
                Member_info member_info = new Member_info(userId, password, userName, userAge);
                databaseReference.child("Info").push().setValue(member_info);
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}
