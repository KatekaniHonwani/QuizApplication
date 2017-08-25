package com.example.codetribestudent.quizapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    boolean questionsAnswered=false;
    static String SCORE = "score";
    RadioGroup rgQuestion1;
    RadioGroup rgQuestion2;
    RadioGroup rgQuestion3;
    RadioGroup rgQuestion4;
    RadioGroup rgQuestion5;

    //Question1
    RadioButton question1a;
    RadioButton question1b;
    RadioButton question1c;

    //Question2
    RadioButton question2a;
    RadioButton question2b;
    RadioButton question2c;

    //Question3
    RadioButton question3a;
    RadioButton question3b;
    RadioButton question3c;

    //Question2
    RadioButton question4a;
    RadioButton question4b;
    RadioButton question4c;

    //Question3
    RadioButton question5a;
    RadioButton question5b;
    RadioButton question5c;
//Entertainment Questions

    EditText answer1;
    EditText answer2;
    EditText answer3;
    EditText answer4;
    EditText answer5;

//Politics Questions

    RadioGroup rgQuestion1a;
    RadioGroup rgQuestion2a;
    RadioGroup rgQuestion3a;
    RadioGroup rgQuestion4a;
    RadioGroup rgQuestion5a;
    //Q1
    RadioButton questionTruea;
    RadioButton questionFalsea;
    //Q2
    RadioButton questionTrueb;
    RadioButton questionFalseb;
    //Q3
    RadioButton questionTruec;
    RadioButton questionFalsec;
    //Q4
    RadioButton questionTrued;
    RadioButton questionFalsed;
    //Q5
    RadioButton questionTruee;
    RadioButton questionFalsee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        String topic=intent.getStringExtra(MainActivity.TOPIC);
        getSupportActionBar().setTitle(topic);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        if(topic.equalsIgnoreCase("Sport"))
        {

            setContentView(R.layout.sport_layout);


            TextView txtTimer=(TextView)findViewById(R.id.textView6);
            reverseTimer(30,txtTimer);

            rgQuestion1=(RadioGroup)findViewById(R.id.radioGroup);
            rgQuestion2=(RadioGroup)findViewById(R.id.radioGroup1);
            rgQuestion3=(RadioGroup)findViewById(R.id.radioGroup2);
            rgQuestion4=(RadioGroup)findViewById(R.id.radioGroup3);
            rgQuestion5=(RadioGroup)findViewById(R.id.radioGroup4);

//Declare radio buttons

            question1a=(RadioButton)findViewById(R.id.rbAnswerQ1a);
            question1b=(RadioButton)findViewById(R.id.rbAnswerQ1b);
            question1c=(RadioButton)findViewById(R.id.rbAnswerQ1c);

            question2a=(RadioButton)findViewById(R.id.rbAnswerQ2a);
            question2b=(RadioButton)findViewById(R.id.rbAnswerQ2b);
            question2c=(RadioButton)findViewById(R.id.rbAnswerQ2c);

            question3a=(RadioButton)findViewById(R.id.rbAnswerQ3a);
            question3b=(RadioButton)findViewById(R.id.rbAnswerQ3b);
            question3c=(RadioButton)findViewById(R.id.rbAnswerQ3c);

            question4a=(RadioButton)findViewById(R.id.rbAnswerQ4a);
            question4b=(RadioButton)findViewById(R.id.rbAnswerQ4b);
            question4c=(RadioButton)findViewById(R.id.rbAnswerQ4c);

            question5a=(RadioButton)findViewById(R.id.rbAnswerQ5a);
            question5b=(RadioButton)findViewById(R.id.rbAnswerQ5b);
            question5c=(RadioButton)findViewById(R.id.rbAnswerQ5c);



        }
        else if(topic.equalsIgnoreCase("Entertainment"))
        {
          setContentView(R.layout.entertainment_layout);

            TextView txtTimer=(TextView)findViewById(R.id.textView7);
            reverseTimer(45,txtTimer);

            answer1=(EditText)findViewById(R.id.edtCassper);
            answer2=(EditText)findViewById(R.id.edtNasty);
            answer3=(EditText)findViewById(R.id.edtRicky);
            answer4=(EditText)findViewById(R.id.edtAmerica);
            answer5=(EditText)findViewById(R.id.edtKhanyi);


        }

        else if(topic.equalsIgnoreCase("Politics"))
        {
                setContentView(R.layout.politics_layout);

            TextView txtTimer=(TextView)findViewById(R.id.textView8);
            reverseTimer(30,txtTimer);

            rgQuestion1a=(RadioGroup)findViewById(R.id.radioGroup1);
            rgQuestion2a=(RadioGroup)findViewById(R.id.radioGroup2);
            rgQuestion3a=(RadioGroup)findViewById(R.id.radioGroup3);
            rgQuestion4a=(RadioGroup)findViewById(R.id.radioGroup4);
            rgQuestion5a=(RadioGroup)findViewById(R.id.radioGroup5);

            questionTruea=(RadioButton)findViewById(R.id.rbAnswerQ1a);
            questionFalsea=(RadioButton)findViewById(R.id.rbAnswerQ1b);

            questionTrueb=(RadioButton)findViewById(R.id.rbAnswerQ2a);
            questionFalseb=(RadioButton)findViewById(R.id.rbAnswerQ2b);

            questionTruec=(RadioButton)findViewById(R.id.rbAnswerQ3a);
            questionFalsec=(RadioButton)findViewById(R.id.rbAnswerQ3b);

            questionTrued=(RadioButton)findViewById(R.id.rbAnswerQ4a);
            questionFalsed=(RadioButton)findViewById(R.id.rbAnswerQ4b);

            questionTruee=(RadioButton)findViewById(R.id.rbAnswerQ5a);
            questionFalsee=(RadioButton)findViewById(R.id.rbAnswerQ5b);

        }


    }

    CountDownTimer  time;

    public void reverseTimer(int Second,final TextView txtFinal)
    {
        time=new CountDownTimer(Second*1000+1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds=(int)(millisUntilFinished/1000);
                int minutes=seconds/60;
                seconds=seconds%60;

                txtFinal.setText(String.format("%02d",minutes) + " : " +String.format("%02d",seconds));
            }

            @Override
            public void onFinish() {

                txtFinal.setText("Completed");
                Intent intent=new Intent(QuestionActivity.this,ResultsActivity.class);
                //intent.putExtra(SCORE,score);
                startActivity(intent);
            }
        }.start();

    }

    public void submit(View view)
    {

         int score=0;

        if(rgQuestion1.getCheckedRadioButtonId()!=-1 && rgQuestion2.getCheckedRadioButtonId()!=-1 && rgQuestion3.getCheckedRadioButtonId()!=-1 && rgQuestion4.getCheckedRadioButtonId()!=-1 && rgQuestion5.getCheckedRadioButtonId()!=-1 )
        {
            questionsAnswered=true;
        }

        if(questionsAnswered){

            switch(rgQuestion1.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ1a:
                {
                    score++;
                    break;
                }

            }

            switch(rgQuestion2.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ2b:
                {
                    score++;
                    break;
                }

            }

            switch(rgQuestion3.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ3c:
                {
                    score++;
                    break;
                }

            }

            switch(rgQuestion4.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ4a:
                {
                    score++;
                    break;
                }

            }

            switch(rgQuestion5.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ5a:
                {
                    score++;
                    break;
                }

            }

            Toast.makeText(QuestionActivity.this, "you have scored "+ score, Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(QuestionActivity.this,ResultsActivity.class);
            intent.putExtra(SCORE,score);
            startActivity(intent);
        }



        else
        {
            questionsAnswered=false;
            Toast.makeText(QuestionActivity.this, "please answer all questions" , Toast.LENGTH_SHORT).show();

        }


    }

    public void answers(View view)
    {
        int score=0;

        String answerCas=answer1.getText().toString();
        String answerNasty=answer2.getText().toString();
        String answerRicky=answer3.getText().toString();
        String answerKim=answer4.getText().toString();
        String answerKhanyi=answer5.getText().toString();

        if(answerCas!=null && answerNasty !=null && answerRicky!=null && answerKim!=null && answerKhanyi!=null )
        {
           if(answerCas.equalsIgnoreCase("2013"))
            {
                score++;
                answer1.setEnabled(false);
            }

            if(answerNasty.equalsIgnoreCase("20"))
            {
                score++;
                answer2.setEnabled(false);
            }

            if(answerRicky.equalsIgnoreCase("Ricky Rick"))
            {
                score++;
                answer3.setEnabled(false);
            }

            if(answerKim.equalsIgnoreCase("Kim Kardashian"))
            {
                score++;
                answer4.setEnabled(false);
            }


            if(answerKhanyi.equalsIgnoreCase("Mandla Mthembu"))
            {
                score++;
                answer5.setEnabled(false);
            }

            Toast.makeText(QuestionActivity.this, "you have scored "+ score, Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(QuestionActivity.this,ResultsActivity.class);
            intent.putExtra(SCORE,score);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(QuestionActivity.this, "please answer all questions" , Toast.LENGTH_SHORT).show();
        }


        if(!"".equals(answerCas))
        {

        }
    }



    public void politicsAnswer(View view)
    {

        int score=0;

        if(rgQuestion1a.getCheckedRadioButtonId()!=-1 && rgQuestion2a.getCheckedRadioButtonId()!=-1 && rgQuestion3a.getCheckedRadioButtonId()!=-1 && rgQuestion4a.getCheckedRadioButtonId()!=-1 && rgQuestion5a.getCheckedRadioButtonId()!=-1 )
        {
            questionsAnswered=true;
        }

        if(questionsAnswered){

            switch(rgQuestion1a.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ1a:
                {
                    score++;
                    break;
                }

            }

            switch(rgQuestion2a.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ2b:
                {
                    score++;
                    break;
                }

            }

            switch(rgQuestion3a.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ3b:
                {
                    score++;
                    break;
                }

            }

            switch(rgQuestion4a.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ4b:
                {
                    score++;
                    break;
                }

            }

            switch(rgQuestion5a.getCheckedRadioButtonId()){

                case R.id.rbAnswerQ5b:
                {
                    score++;
                    break;
                }

            }

            Toast.makeText(QuestionActivity.this, "you have scored "+ score + "out of 5 questions", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(QuestionActivity.this,ResultsActivity.class);
            intent.putExtra(SCORE,score);
            startActivity(intent);

        }

        else
        {
            Toast.makeText(QuestionActivity.this, "please answer all questions" , Toast.LENGTH_SHORT).show();
        }


    }

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
}
