package com.example.woojin.management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this.getIntent());
        String userId = intent.getStringExtra("userId");
        String password = intent.getStringExtra("password");

        EditText idText = (EditText)findViewById(R.id.idText);
        EditText passwordText = (EditText)findViewById(R.id.passwordText);
        TextView welcomeMessage = (TextView)findViewById(R.id.welcomeMessage);

        idText.setText(userId);
        passwordText.setText(password);
        welcomeMessage.setText(userId+"님 로그인 되었습니다.");

    }
}
