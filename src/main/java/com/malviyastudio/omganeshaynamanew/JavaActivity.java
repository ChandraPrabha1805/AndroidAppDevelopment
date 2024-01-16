package com.malviyastudio.omganeshaynamanew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        CardView exit=findViewById(R.id.cardJavaBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JavaActivity.this, HomeActivity.class));
            }
        });
        CardView oops=findViewById(R.id.cardJavaOOPS);
        oops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(JavaActivity.this, TopicDetailActivity.class);
                it.putExtra("title","OOPS concept");
                startActivity(it);
            }
        });
        CardView syntax=findViewById(R.id.cardJavaSyntax);
        syntax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(JavaActivity.this, TopicDetailActivity.class);
                it.putExtra("title","Syntax and BLF");
                startActivity(it);
            }
        });
        CardView exception=findViewById(R.id.cardJavaExceptionHandling);
        exception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(JavaActivity.this, TopicDetailActivity.class);
                it.putExtra("title","Exception Handling");
                startActivity(it);
            }
        });
        CardView collection=findViewById(R.id.cardJavaCollection);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(JavaActivity.this, TopicDetailActivity.class);
                it.putExtra("title","Collection Framework");
                startActivity(it);
            }
        });
        CardView multithreading=findViewById(R.id.cardJavaMultithreading);
        multithreading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(JavaActivity.this, TopicDetailActivity.class);
                it.putExtra("title"," Multithreading");
                startActivity(it);
            }
        });
    }
}