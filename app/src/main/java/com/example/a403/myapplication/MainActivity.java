package com.example.a403.myapplication;

import android.graphics.Color;
import android.media.Image;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Chronometer chro1;
    Switch set;
  FrameLayout f1;
    LinearLayout l1,l2;
    Button b1finish;
   EditText t1,t2,t3;
    TextView v1,v2,v3;
    RadioButton r1,r2,r3;
    ImageView image;
    Image man,kid,student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chro1=(Chronometer)findViewById(R.id.chronometer1);
        set=(Switch) findViewById(R.id.switch2);
        b1finish=(Button) findViewById(R.id.button);
        t1=(EditText) findViewById(R.id.editText2);
        t2=(EditText) findViewById(R.id.editText3);
        t3=(EditText) findViewById(R.id.editText4);
        v1=(TextView) findViewById(R.id.textView5);
        v2=(TextView) findViewById(R.id.textView6);
        v3=(TextView) findViewById(R.id.textView7);
        r1=(RadioButton) findViewById(R.id.radioButton);
        r2=(RadioButton) findViewById(R.id.radioButton2);
        r3=(RadioButton) findViewById(R.id.radioButton3);
        image=(ImageView) findViewById(R.id.imageView);


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
         r1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 image.setImageResource(R.drawable.man);
             }
         });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.kid);
            }
        });

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.student);
            }
        });


        b1finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=t1.getText().toString();
                String s2=t2.getText().toString();
                String s3=t3.getText().toString();
                int su=Integer.parseInt(s1)+Integer.parseInt(s2)+Integer.parseInt(s3);
                v1.setText(su);

                double sum;
                double hal;
                double lastsum;
              if(r1.isClickable()){
                  sum=((Integer.parseInt(s1)*15000)+(Integer.parseInt(s2)*12000)+(Integer.parseInt(s3)*6000));
                  hal=sum*0.05;
                   lastsum=sum-hal;
                  v2.setText(String.format("%.1f",hal));
                  v3.setText(String.format("%.1f",lastsum));

              }
                if(r2.isClickable()){
                    sum=((Integer.parseInt(s1)*15000)+(Integer.parseInt(s2)*12000)+(Integer.parseInt(s3)*6000));
                    hal=sum*0.10;
                    lastsum=sum-hal;
                    v2.setText(String.format("%.1f",hal));
                    v3.setText(String.format("%.1f",lastsum));

                }

                if(r3.isClickable()){
                    sum=((Integer.parseInt(s1)*15000)+(Integer.parseInt(s2)*12000)+(Integer.parseInt(s3)*6000));
                    hal=sum*0.20;
                    lastsum=sum-hal;
                    v2.setText(String.format("%.1f",hal));
                    v3.setText(String.format("%.1f",lastsum));

                }


            }
        });
    }
}
