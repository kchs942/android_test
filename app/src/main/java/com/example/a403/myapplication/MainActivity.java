package com.example.a403.myapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Chronometer chro1;
    Switch set;
  FrameLayout f1;
    LinearLayout l1,l2;
    Button b1finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chro1=(Chronometer)findViewById(R.id.chronometer1);
        set=(Switch) findViewById(R.id.switch2);
        b1finish=(Button) findViewById(R.id.button);

         set.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 chro1.setBase(SystemClock.elapsedRealtime());
                 chro1.start();
                 chro1.setTextColor(Color.BLUE);
                 if(b){
                     f1.setVisibility(View.VISIBLE);
                     l2.setVisibility(View.VISIBLE);
                     l1.setVisibility(View.INVISIBLE);
                 }
                 else f1.setVisibility(View.INVISIBLE);
             }
         });


        b1finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
