package com.example.day4_task2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondsActivity extends AppCompatActivity {

    TextView from, sentMessage;
    Button closeBtn;
    SharedPreferences preferences;
    String mobile, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        from = findViewById(R.id.senderMobile);
        sentMessage = findViewById(R.id.receivedMessage);

        closeBtn = findViewById(R.id.backButton);

        preferences = getSharedPreferences("SAVED_PREF", Context.MODE_PRIVATE);
        mobile = preferences.getString("MOBILE", "not found");
        message = preferences.getString("MESSAGE", "not found");

        from.setText(mobile);
        sentMessage.setText(message);

        closeBtn.setOnClickListener(v -> finish());

    }
}