package com.example.teng.demopagecourse;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    int count =0; //button click time
    int runner; //runner id in team
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button to start one match
        final Button buttonBegin = findViewById(R.id.btBegin);
        //Button of every team
        final Button buttonTeam = findViewById(R.id.btTeam);
        //Timer of whole match
        final Chronometer chronoAll = findViewById(R.id.chrnoAll);
        //Button to stop one match
        final Button buttonEnd = findViewById(R.id.btStop);
        //Click to view the result
        final Button buttonResult = findViewById(R.id.btResult);
        //Timer of one team
        final Chronometer chronoTeam = findViewById(R.id.chrnoTeam);
        //Start the match
        buttonBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronoAll.setBase(SystemClock.elapsedRealtime());
                chronoAll.start();
                buttonTeam.setBackgroundColor(getResources().getColor(R.color.color4));
                buttonTeam.setText("spint");
                chronoTeam.setBase(SystemClock.elapsedRealtime());
                chronoTeam.start();
            }
        }
        );


        buttonTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int round = count%5;
                switch(round){
                    case 0:
                        buttonTeam.setBackgroundColor(getResources().getColor(R.color.color0));
                        buttonTeam.setText("tour d'obstacle");
                        count++;
                      /*  String time = chronoTeam.getText()+"";
                        Log.d("testTime",time);*/
                        chronoTeam.setBase(SystemClock.elapsedRealtime());
                        break;
                    case 1:
                        buttonTeam.setBackgroundColor(getResources().getColor(R.color.color1));
                        buttonTeam.setText("pit-stop");
                        count++;
                        chronoTeam.setBase(SystemClock.elapsedRealtime());
                        break;
                    case 2:
                        buttonTeam.setBackgroundColor(getResources().getColor(R.color.color2));
                        buttonTeam.setText("spint");
                        count++;
                        chronoTeam.setBase(SystemClock.elapsedRealtime());
                        break;
                    case 3:
                        buttonTeam.setBackgroundColor(getResources().getColor(R.color.color3));
                        buttonTeam.setText("tour d'obstacle");
                        count++;
                        chronoTeam.setBase(SystemClock.elapsedRealtime());
                        break;
                    case 4:
                        buttonTeam.setBackgroundColor(getResources().getColor(R.color.color4));
                        buttonTeam.setText("spint");
                        count++;
                        chronoTeam.setBase(SystemClock.elapsedRealtime());
                        runnerDone(count);
                        break;
                }
            }
        });

        buttonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronoAll.stop();
                chronoTeam.stop();
            }
        });

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
    public void runnerDone(int count){
        switch (count/5){
            case 1 :
                runner = R.id.runner11;
                break;
            case 2 :
                runner = R.id.runner12;
                break;
            case 3 :
                runner = R.id.runner13;
                break;
            case 4 :
                runner = R.id.runner21;
                break;
            case 5 :
                runner = R.id.runner22;
                break;
            case 6 :
                runner = R.id.runner23;
                break;
        }
        CheckBox check = findViewById(runner);
        check.setChecked(true);
    }

}
