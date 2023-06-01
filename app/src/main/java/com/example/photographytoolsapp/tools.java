package com.example.photographytoolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tools extends AppCompatActivity {

    Button tool2_brn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        tool2_brn = findViewById(R.id.button6);

        tool2_brn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext() , tool2.class);
                startActivity(i);
            }
        });
    }
}