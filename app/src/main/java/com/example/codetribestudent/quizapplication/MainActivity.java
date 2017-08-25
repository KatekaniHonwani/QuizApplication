package com.example.codetribestudent.quizapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    Button btnPolitics;
    Button btnSport;
    Button btnEntertainment;
    static String TOPIC="Topics";
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntertainment = (Button) findViewById(R.id.btnEntertainment);
        btnSport = (Button) findViewById(R.id.btnSport);
        btnPolitics = (Button) findViewById(R.id.btnPolitics);

        btnSport.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Quiz Instruction ");
                builder.setMessage("1. Read the questions carefully before answering \n" +
                                    "2. There's time allocated to each topic, please use it wisely. \n" +

                                    "3.Make sure you answer all questions before submitting. \n" +
                                    "4.Good luck, Hope you enjoy!!!   ");
                builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(MainActivity.this,QuestionActivity.class);
                        intent.putExtra(TOPIC,"SPORT");
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btnPolitics.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Quiz Instruction ");
                builder.setMessage("1. Read the questions carefully before answering \n" +
                        "2. There's time allocated to each topic, please use it wisely. \n" +
                        "3.Make sure you answer all questions before submitting. \n" +
                        "4.Good luck, Hope you enjoy!!!   ");
                builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(MainActivity.this,QuestionActivity.class);
                        intent.putExtra(TOPIC,"POLITICS");
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btnEntertainment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Quiz Instruction ");
                builder.setMessage("1. Read the questions carefully before answering \n" +
                        "2. There's time allocated to each topic, please use it wisely. \n" +
                        "3.Make sure you answer all questions before submitting. \n" +
                        "4.Good luck, Hope you enjoy!!!   ");
                builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(MainActivity.this,QuestionActivity.class);
                        intent.putExtra(TOPIC,"ENTERTAINMENT");
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }


    /*
    public void politics(View view)
    {
        Intent intent=new Intent(MainActivity.this,QuestionActivity.class);
        intent.putExtra(TOPIC,"Politics");
        startActivity(intent);
    }

    public void entertainment(View view)
    {
        Intent  intent=new Intent(MainActivity.this,QuestionActivity.class);
        intent.putExtra(TOPIC,"Entertainment");
        startActivity(intent);
    }
    */
/*
    public void sport(View view)
    {
        Intent  intent=new Intent(MainActivity.this,QuestionActivity.class);
        intent.putExtra(TOPIC,"Sport");
        startActivity(intent);
    }
    */
}
