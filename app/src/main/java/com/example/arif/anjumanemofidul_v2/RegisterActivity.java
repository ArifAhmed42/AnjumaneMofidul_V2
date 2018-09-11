package com.example.arif.anjumanemofidul_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText name,email,phone,password,confirmpassword;
    Button register,back;
    Intent intentHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);
        password = (EditText)findViewById(R.id.password);
        confirmpassword = (EditText)findViewById(R.id.confirmpassword);
        register = (Button)findViewById(R.id.register);
        back = (Button)findViewById(R.id.back);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference nameRef = database.getReference("Name");
        final DatabaseReference emRef = database.getReference("Email");
        final DatabaseReference phRef = database.getReference("Phone");
        final DatabaseReference passRef = database.getReference("Password");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentHome = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intentHome);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = name.getText().toString();
                String emailString = email.getText().toString();
                String phoneString = phone.getText().toString();
                String passString = password.getText().toString();
                String cpassString = confirmpassword.getText().toString();
                if (nameString.length()>0 && emailString.length()>0 && phoneString.length()>0 && passString.length()>0 && cpassString.length()>0)
                {
                    if (cpassString.equals(passString)) {
                        nameRef.setValue(nameString);
                        emRef.setValue(emailString);
                        phRef.setValue(phoneString);
                        passRef.setValue(cpassString);

                        intentHome = new Intent(RegisterActivity.this, MenuActivity.class);
                        startActivity(intentHome);
                        finish();
                    }

                    else {
                        Toast.makeText(getApplicationContext(), "Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }

                else {
                    Toast.makeText(getApplicationContext(), "Those fields can not be empty", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
