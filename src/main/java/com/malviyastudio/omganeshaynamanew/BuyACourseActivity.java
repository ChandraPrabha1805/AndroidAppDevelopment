package com.malviyastudio.omganeshaynamanew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyACourseActivity extends AppCompatActivity {

    private String[][] course=
          {
              {"Udemy: Offers a wide range of Java courses for different skill levels.","999"},
              {"Coursera: Provides courses from universities and organizations around the world.","333"},
              {"edX: Similar to Coursera, offering courses from top universities.","454"},
              {"Pluralsight: Focuses on technology-related courses, including Java.","454"},
              {"Codecademy: An interactive learning platform with Java courses.","568"}
          };
    private String[]courseDetail=
            {
                    "Development\n"+
                    "It and software\n"+
                    "Business\n"+
                    "Design\n"+
                    "Language\n"+
                    "Development",
                    "It and software",
                    "Business",
                    "Design"
            };
    ListView lv;
    Button btnBack,btnGoToCart;
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_acourse);
        lv=findViewById(R.id.ListViewBAC);
        btnBack=findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyACourseActivity.this, HomeActivity.class));

            }
        });
        list =new ArrayList();
        for(int i=0;i<course.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("Line1" ,course[i][0]);
            item.put("Line2" ,"Total cost" +course[i][1]+"-/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2"},
                new int[]{R.id.textline_a,R.id.textline_b});
        lv.setAdapter(sa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it= new Intent(BuyACourseActivity.this,BuyACourseDetailActivity.class);
                it.putExtra("text1",course[i][0]);
                it.putExtra("text2",courseDetail[i]);

            }
        });
    }
}
