package com.example.day4_task2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button sendBtn, closeBtn;
    EditText mobileED, messageED;
    String mobile, message;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, SecondsActivity.class);

        mobileED = findViewById(R.id.mobileEditText);
        messageED = findViewById(R.id.messageEditText);

        sendBtn = findViewById(R.id.sendButton);
        closeBtn = findViewById(R.id.closeButton);

        sendBtn.setOnClickListener(v -> {

            mobile = mobileED.getText().toString();
            message = messageED.getText().toString();

            preferences = getSharedPreferences("SAVED_PREF", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("MOBILE", mobile);
            editor.putString("MESSAGE", message);
            editor.commit();
            startActivity(intent);
        });



    }
}