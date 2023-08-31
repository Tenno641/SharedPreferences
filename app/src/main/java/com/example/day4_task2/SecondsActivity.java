package com.example.day4_task2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.day4_task2.adapter.DataBaseAdapter;
import com.example.day4_task2.data.Model;

public class SecondsActivity extends AppCompatActivity {

    TextView from, sentMessage;
    Button closeBtn;

    DataBaseAdapter dataBaseAdapter;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        from = findViewById(R.id.senderMobile);
        sentMessage = findViewById(R.id.receivedMessage);
        closeBtn = findViewById(R.id.backButton);

        dataBaseAdapter = new DataBaseAdapter(this);
        model = dataBaseAdapter.getRow();

        from.setText(model.getMobile());
        sentMessage.setText(model.getMessage());

        closeBtn.setOnClickListener(v -> finish());

    }
}