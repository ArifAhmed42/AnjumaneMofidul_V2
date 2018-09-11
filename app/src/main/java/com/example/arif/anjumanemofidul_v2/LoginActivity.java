package com.example.arif.anjumanemofidul_v2;

import android.content.Intent;
import android.support.annotation.NonNull;
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

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    TextView register;
    Button back,login;
    Intent intent;
    EditText email,password;
    String emailvalue,passvalue,phonevalue,namevalue,flag; //databease read value
    String emailString,passString; //input value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (TextView)findViewById(R.id.register);
        back = (Button)findViewById(R.id.back);
        login = (Button)findViewById(R.id.login);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference emRef = database.getReference("Email");
        final DatabaseReference passRef = database.getReference("Password");
        final DatabaseReference phRef = database.getReference("Phone");
        final DatabaseReference nameRef = database.getReference("Name");

        //Reading Data from database...........................

        emRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                emailvalue = String.valueOf(dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        passRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                passvalue = String.valueOf(dataSnapshot.getValue());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        phRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                phonevalue = String.valueOf(dataSnapshot.getValue());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        nameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                namevalue = String.valueOf(dataSnapshot.getValue());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });



        //..............................................

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 emailString = email.getText().toString();
                 passString = password.getText().toString();


                if (emailString.length()>0 && passString.length()>0) {

                     if(emailvalue.equals(emailString) && passvalue.equals(passString))
                     {
                         flag = "true";

                         intent = new Intent(LoginActivity.this, ProfileActivity.class);
                         final String[] titles = new String[] { namevalue,
                                 emailvalue, phonevalue };
                         intent.putExtra("titles", titles);
                         startActivity(intent);
                         finish();

                         Toast.makeText(getApplicationContext(), "Log in successful", Toast.LENGTH_SHORT).show();
                     }

                     else {
                                Toast.makeText(getApplicationContext(), "Email or Password is incorrect", Toast.LENGTH_SHORT).show();
                     }

                }

                else {
                    Toast.makeText(getApplicationContext(), "Those fields can not be empty", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
