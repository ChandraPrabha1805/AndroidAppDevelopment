package com.malviyastudio.omganeshaynamanew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.HardwareRenderer;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopicDetailActivity extends AppCompatActivity {
    private String[][] topic_detail1=
            {
                    {"Encapsulation :This involves bundling the data (attributes) and the methods (functions) that operate on the data into a single unit, known as an object. Encapsulation helps in hiding the internal details of an object and exposing only what is necessary."},
                    {"Inheritance :Inheritance allows a new class (subclass or derived class) to inherit attributes and methods from an existing class (base class or superclass). This promotes code reusability and establishes a hierarchy among classes."},
                    {"Polymorphism:Polymorphism means many forms It allows objects of different classes to be treated as objects of a common base class This enables a single interface to represent different types of objects, making code more flexible and extensible."},
                    {"Abstraction :Abstraction involves simplifying complex systems by modeling classes based on the essential properties and behaviors they share. It focuses on what an object does rather than how it achieves its functionality."}
            };
    private String[][] topic_detail2=
            {
                    {"Data type:Java has primitive data types (int, float, boolean, etc.) and object reference types."},
                    {"Control flow:Conditional statements include if, else, and switch."},
                    {"Classes and Objects:Java is an object-oriented language, and programs are organized into classes."},
                    {"Methods:Methods define behavior and are declared within classes."}
            };
    private String[][] topic_detail3=
            {
                    {"Thread Creation:Threads can be created in Java by extending the Thread class or implementing the Runnable interface."},
                    {"Thread Lifecycle:Threads go through various states, including NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, and TERMINATED."},
                    {"Synchronization:Multithreading introduces the risk of data inconsistency when multiple threads access shared resources simultaneously."},
                    {"Thread priorities:Threads can have different priorities ranging from Thread.MIN_PRIORITY to Thread.MAX_PRIORITY" },
            };
    private String[][] topic_detail4=
            {
                    {"Exception Types:Checked exceptions are checked at compile-time and must be either caught using a try-catch block or declared in the method signature using the throws keyword."},
                    {"Exception Hirarchy Lifecycle:All exceptions in Java are subclasses of the Throwable class."},
                    {"Handling exception:Exceptions are handled using try, catch, finally, and throw blocks."},
                    {"Throwing exception:The throw keyword is used to explicitly throw an exception." },
            };
    private String[][] topic_detail5=
            {
                    {"Interfaces:Key interfaces include Collection, List, Set, Map, and their various subinterfaces."},
                    {"Iterator:Java provides several standard implementations of these interfaces.."},
                    {"Generics:Iterators are used to traverse elements in a collection.."},
                    {"Sorting and searching:Generics were introduced to the Collections Framework to provide type safety." },
            };
    TextView tv;
    Button btn;
    String [][]topic_detail={};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        tv=findViewById(R.id.textJavaDetailTitle);
        btn=findViewById(R.id.buttonBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("OOPS Concept")==0)
            topic_detail=topic_detail1;
        else
        if(title.compareTo("Syntax and BLF")==0)
            topic_detail=topic_detail2;
        else
            if(title.compareTo("Multithreading")==0)
        topic_detail=topic_detail3;
        else
            if(title.compareTo("Exception")==0)
        topic_detail=topic_detail4;
        else
            if(title.compareTo("Collection")==0)
        topic_detail=topic_detail5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TopicDetailActivity.this, JavaActivity.class));

            }
        });
        list =new ArrayList();
        for(int i=0;i<topic_detail.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("Line1" ,topic_detail[i][0]);
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1"},
                new int[]{R.id.textline_a}
                );
        ListView lst=findViewById(R.id.ListViewTopicDetail);
                lst.setAdapter(sa);
    }
}