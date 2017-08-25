package com.example.codetribestudent.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView tvSportScore;
    Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent= getIntent();
        int score = intent.getIntExtra(QuestionActivity.SCORE,0);

        int scorePercent=(score/5)*100;
        tvSportScore = (TextView)findViewById(R.id.textView);
        tvSportScore.setText(String.valueOf("Hey  Your Score Is "+score + " and your average percent is "+scorePercent));

        btnHome=(Button)findViewById(R.id.button);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Creating a back button
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case android.R.id.home:
                this.finish();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    */
}
