package com.example.photographytoolsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import io.github.muddz.styleabletoast.StyleableToast;

//import com.google.firebase.firestore.FirebaseFirestore;

//import java.util.HashMap;

public class Home extends AppCompatActivity {
    Button login_brn , signup_btn;

    FirebaseAuth auth;
    FirebaseUser currentUser;
    Button start_brn,button3;
    EditText editTextTextPersonName,editTextTextPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        login_brn = findViewById(R.id.btnn);

        start_brn = findViewById(R.id.button4);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        button3 = findViewById(R.id.btnn);
        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();



        login_brn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editTextTextPersonName.getText().toString();
                String password = editTextTextPassword.getText().toString();


                if (editTextTextPersonName.getText().toString().contentEquals("")) {


                    StyleableToast.makeText(Home.this,"Please Type Your Email",R.style.exampletoast).show();


                } else if (editTextTextPassword.getText().toString().contentEquals("")) {

                    StyleableToast.makeText(Home.this,"Please Type Your Password",R.style.exampletoast).show();





                } else

                    auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()){
                                Toast.makeText(Home.this, "Logging Successfully" ,Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Home.this,Photography_tools.class);
                                startActivity(i);


                            }else {
                                Toast.makeText(Home.this, "Error   ", Toast.LENGTH_LONG).show();
                            }
                        }
                    });



            }
        });

        signup_btn = findViewById(R.id.button4);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,Create_account.class);
                startActivity(i);
            }
        });




    }
}