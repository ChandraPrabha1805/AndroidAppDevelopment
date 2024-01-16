package com.malviyastudio.omganeshaynamanew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TopicDetailActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        tv=findViewById(R.id.textJavaDetailTitle);
        btn=findViewById(R.id.buttonBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TopicDetailActivity.this, JavaActivity.class));

            }
        });
    }
}