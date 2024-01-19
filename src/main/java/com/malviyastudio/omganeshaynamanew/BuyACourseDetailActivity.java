package com.malviyastudio.omganeshaynamanew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuyACourseDetailActivity extends AppCompatActivity {

    TextView tvCourseName,tvTotalCost;
    TextView edDetails;
    Button btnback,btnAddToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_acourse_detail);
        tvCourseName=findViewById(R.id.textCourseTitle);
        tvTotalCost=findViewById(R.id.textViewTotalCost);
        edDetails=findViewById(R.id.textViewMultiLine);
        btnback=findViewById(R.id.buttonBack);
        btnAddToCart=findViewById(R.id.buttonAddToCart);

        edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvCourseName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyACourseDetailActivity.this, BuyACourseActivity.class));

            }
        });

    }
}