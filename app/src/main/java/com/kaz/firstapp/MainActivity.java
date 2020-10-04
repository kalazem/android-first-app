package com.kaz.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    LinearLayout myLayout;
    TextView myTextView;
    ScrollView myScrollView;
    EditText myEditText;
    Button myButton;

    ArrayList<Student> students = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Working with XML
        myTextView = findViewById(R.id.myTV1);
        myTextView.setText("Hello From Java");

        myEditText = findViewById(R.id.myPT);

        myButton = findViewById(R.id.myBtn1);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               String str = myEditText.getText().toString();
               myTextView.setText(str);
            }
        });

    }

    void showMyNumbers() {
        int i;
        String str = "";

        for (i = 0; i < 20; i++) {
            str = str + "Number" + i + "\n";
        }
        myTextView.setText(myTextView.getText()+" \n"+str);
    }


    //Deprecated code
    void firstImplementations() {
        myLayout = new LinearLayout(this);

        myTextView = new TextView(this);

        //user-editable text
        myEditText = new EditText(this);
        myTextView.setText("Hello Wrold Edited!");
        myTextView.setTextSize(30);
        myTextView.setTextColor(Color.rgb(250, 0, 255));

        myLayout.addView(myTextView);

        myScrollView = new ScrollView(this);
        myScrollView.addView(myLayout);

//        showMyNumbers();
        showSomeStudents();
        //setContentView(myScrollView);
    }

    void showSomeStudents() {

        //Add students to list
        students.add(new Student("Bob",21, 55.5, 66.5, 33, true));
        students.add(new Student("Mary",19, 70.3, 323,323,false));
        students.add(new Student("Fred",35, 66.0, 232, 2323,true));


        String str="";
        String gender = "Male";
        for(Student s:students){
            gender = (s.isGender()) ? "Male" : "Female";
            str=str+"Name " + s.getName() + " "+
                    " age " + s.getAge() +  " "+
                    "Height" + s.getHeight()+ " "+
                    "Weight" + s.getWeight() + " "+
                    "gender"+ gender +"\n\n\n";
        }

        myTextView.setText(myTextView.getText()+" \n"+str);
    }
}