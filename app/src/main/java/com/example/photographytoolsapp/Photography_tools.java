package com.example.photographytoolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Photography_tools extends AppCompatActivity {

    ImageButton tools_brn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photography_tools);

        tools_brn = findViewById(R.id.imageButton4);

        tools_brn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext() , tools.class);
                startActivity(i);
            }
        });
    }
}