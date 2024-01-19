package com.malviyastudio.omganeshaynamanew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String username= sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome "+username, Toast.LENGTH_SHORT).show();

        CardView logout=findViewById(R.id.cardLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
            });
            CardView java=findViewById(R.id.cardJava);
            java.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    startActivity(new Intent(HomeActivity.this, JavaActivity.class));
                }
            });
                CardView buyACourse=findViewById(R.id.cardBuyACourse);
                buyACourse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        startActivity(new Intent(HomeActivity.this, BuyACourseActivity.class));
                    }

                });

    }
}