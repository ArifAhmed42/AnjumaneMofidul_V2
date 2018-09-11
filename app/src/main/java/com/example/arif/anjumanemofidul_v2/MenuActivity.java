package com.example.arif.anjumanemofidul_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    ImageView information,news,ambulance,donation,grave,profile;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        information = (ImageView)findViewById(R.id.information);
        news = (ImageView)findViewById(R.id.news);
        ambulance = (ImageView)findViewById(R.id.ambulance);
        donation = (ImageView)findViewById(R.id.donation);
        grave = (ImageView)findViewById(R.id.grave);
        profile = (ImageView)findViewById(R.id.profile);


        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this,"news clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuActivity.this, AmbulanceActivity.class);
                startActivity(intent);
                finish();
            }
        });

        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuActivity.this, DonationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //.........................................
        grave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MenuActivity.this, GraveActivity.class);
                startActivity(intent);
                finish();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    intent = new Intent(MenuActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

            }
        });


        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this,"Information clicked" , Toast.LENGTH_SHORT).show();
            }
        });


    }
}
