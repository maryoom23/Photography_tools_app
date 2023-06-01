package com.example.photographytoolsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_account extends AppCompatActivity {

   // FirebaseFirestore firestore;

    EditText emaill, phonee, psswrd,copsswrd;
    Button btn;
    FirebaseAuth auth;
    private DatabaseReference reference;
    private FirebaseDatabase database;

    FirebaseUser currentUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        emaill = findViewById(R.id.email);
        phonee = findViewById(R.id.phone);
        psswrd = findViewById(R.id.psswrd);
        copsswrd = findViewById(R.id.copsswrd);
        btn = findViewById(R.id.btn);


        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("UserDetails");

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String email = emaill.getText().toString();
        String phone = phonee.getText().toString();
        String passwor = psswrd.getText().toString();
        String password = copsswrd.getText().toString();


        if (emaill.getText().toString().contentEquals("")) {


            Toast toast = Toast.makeText(getApplicationContext(), " Please Type Your Email Address  ", Toast.LENGTH_LONG);
            toast.show();


        } else if (phonee.getText().toString().contentEquals("")) {

            Toast toast = Toast.makeText(getApplicationContext(), " Please Type Your Phone No. ", Toast.LENGTH_LONG);
            toast.show();

        } else if (psswrd.getText().toString().contentEquals("")) {

            Toast toast = Toast.makeText(getApplicationContext(), " Please Type Your Password  ", Toast.LENGTH_LONG);
            toast.show();

        } else if (copsswrd.getText().toString().contentEquals("")) {

            Toast toast = Toast.makeText(getApplicationContext(), " Please Retype Your Password  ", Toast.LENGTH_LONG);
            toast.show();
        } else {

            //____________________________________________
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){

                        reference.setValue("").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if(task.isSuccessful()){

                                    //======================================
                                    //       Toast.makeText(SignUp.this, "Successfully registered", Toast.LENGTH_SHORT).show();

                                    AlertDialog alertDialog = new AlertDialog.Builder(Create_account.this)
                                            .setTitle("SIGN UP ")
                                            .setMessage(" The User Has Been Created ")

                                            .setNegativeButton("Login", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                    Intent intent =new Intent(Create_account.this,Home.class);
                                                    startActivity(intent);                                                    }
                                            })
                                            .show();
                                    //======================================

                                }else{


                                    Toast.makeText(Create_account.this, task.getResult().toString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



                       /// Toast.makeText(Create_account.this, task.getResult().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



    }
});



    }
}