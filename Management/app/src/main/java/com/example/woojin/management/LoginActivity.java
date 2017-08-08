package com.example.woojin.management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class LoginActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    EditText idText;
    EditText passwordText;
    Button loginButton;
    TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseReference = FirebaseDatabase.getInstance().getReference("Info");
        idText = (EditText)findViewById(R.id.idText);
        passwordText = (EditText)findViewById(R.id.passwordText);

        loginButton = (Button)findViewById(R.id.loginButton);
        registerButton = (TextView) findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
                        while(child.hasNext()){
                            if(child.next().child("Info").child("userId").getKey().equals(idText.getText().toString())){
                                Toast.makeText(getApplicationContext(), "로그인",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("userId", idText.getText().toString());
                                intent.putExtra("password", passwordText.getText().toString());
                                startActivity(intent);
                                return;
                            }
                        }
                        Toast.makeText(getApplicationContext(), "아이디가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
    }
}
