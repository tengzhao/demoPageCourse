package com.example.teng.demopagecourse;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.LinearLayout;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
   //button click time
    int runner; //runner id in team
    int numTeam = 3;////////////////
    int[] count = new int[numTeam];
    LinearLayout listTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button to start one match
        final Button buttonBegin = findViewById(R.id.btBegin);
        listTeam = findViewById(R.id.listTeam);
       // final LinearLayout listTeam = findViewById(R.id.listTeam);
        //Button of every team

        //final Button buttonTeam = findViewById(R.id.btTeam);
        //Timer of whole match
        final Chronometer chronoAll = findViewById(R.id.chrnoAll);
        //Button to stop one match
        final Button buttonEnd = findViewById(R.id.btStop);
        //Click to view the result
        final Button buttonResult = findViewById(R.id.btResult);
        //Timer of one team
        //final Chronometer chronoTeam = findViewById(R.id.chrnoTeam);

        for(int i=0;i<numTeam;i++){
            View oneTeam = View.inflate(this, R.layout.content_oneequipe, null);
            listTeam.addView(oneTeam);
        }
        //Start the match
        buttonBegin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                chronoAll.setBase(SystemClock.elapsedRealtime());
                chronoAll.start();
                for(int i=0;i<numTeam;i++) {
                    Button buttonTeam = listTeam.getChildAt(i).findViewById(R.id.btTeam);
                    buttonTeam.setEnabled(true);
                    Chronometer chronoTeam = listTeam.getChildAt(i).findViewById(R.id.chrnoTeam);
                    buttonTeam.setBackgroundColor(getResources().getColor(R.color.color4));
                    buttonTeam.setText("spint");
                    chronoTeam.setBase(SystemClock.elapsedRealtime());
                    chronoTeam.start();
                }

            }
        }
        );
        Log.i("testTime1",Long.toString(System.currentTimeMillis()));
        for(int i=0;i<numTeam;i++) {
            Log.i("testTime2",Long.toString(System.currentTimeMillis()));
            final int numberTeam =i;
            final Button buttonTeam = listTeam.getChildAt(i).findViewById(R.id.btTeam);
            final Chronometer chronoTeam = listTeam.getChildAt(i).findViewById(R.id.chrnoTeam);
            buttonTeam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int round = count[numberTeam]%5;
                    switch(round){
                        case 0:
                            buttonTeam.setBackgroundColor(getResources().getColor(R.color.color0));
                            buttonTeam.setText("tour d'obstacle");
                            count[numberTeam]++;
                      /*  String time = chronoTeam.getText()+"";
                        Log.d("testTime",time);*/
                            chronoTeam.setBase(SystemClock.elapsedRealtime());
                            break;
                        case 1:
                            buttonTeam.setBackgroundColor(getResources().getColor(R.color.color1));
                            buttonTeam.setText("pit-stop");
                            count[numberTeam]++;
                            chronoTeam.setBase(SystemClock.elapsedRealtime());
                            break;
                        case 2:
                            buttonTeam.setBackgroundColor(getResources().getColor(R.color.color2));
                            buttonTeam.setText("spint");
                            count[numberTeam]++;
                            chronoTeam.setBase(SystemClock.elapsedRealtime());
                            break;
                        case 3:
                            buttonTeam.setBackgroundColor(getResources().getColor(R.color.color3));
                            buttonTeam.setText("tour d'obstacle");
                            count[numberTeam]++;
                            chronoTeam.setBase(SystemClock.elapsedRealtime());
                            break;
                        case 4:
                            buttonTeam.setBackgroundColor(getResources().getColor(R.color.color4));
                            buttonTeam.setText("spint");
                            count[numberTeam]++;
                            chronoTeam.setBase(SystemClock.elapsedRealtime());
                            runnerDone(count[numberTeam],numberTeam);
                            break;
                    }
                }
            });

        }
        Log.i("testTime3",Long.toString(System.currentTimeMillis()));

        buttonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronoAll.stop();
                for(int i=0;i<numTeam;i++) {
                    Chronometer chronoTeam = listTeam.getChildAt(i).findViewById(R.id.chrnoTeam);
                    chronoTeam.stop();
                }

            }
        });

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
    public void runnerDone(int count,int team){
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
        CheckBox check = listTeam.getChildAt(team).findViewById(runner);
        //check.setChecked(true);
        check.setVisibility(View.VISIBLE);

    }

}
