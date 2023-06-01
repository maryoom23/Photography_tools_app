package com.example.photographytoolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tool2 extends AppCompatActivity {

    Button tool3_brn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool2);

        tool3_brn = findViewById(R.id.button7);

        tool3_brn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext() , tool3.class);
                startActivity(i);
            }
        });
    }
}