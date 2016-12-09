package com.example.a403.myapplication;

import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer chro1;
    Switch set;
  FrameLayout f1,f2;
    LinearLayout l1,l2;
    Button b1finish,timebutton,b3,b4;
   EditText t1,t2,t3;
    TextView v1,v2,v3;
    RadioButton r1,r2,r3,r4,r5;
    ImageView image;
    Image man,kid,student;
    CalendarView date;
    TimePicker time;

    int year;
    int month;
    int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        f1=(FrameLayout) findViewById(R.id.f1);
        f2=(FrameLayout) findViewById(R.id.f2);
        l1=(LinearLayout) findViewById(R.id.l1);
        l2=(LinearLayout) findViewById(R.id.l2);

        chro1=(Chronometer)findViewById(R.id.chronometer1);
        set=(Switch) findViewById(R.id.switch2);
        b1finish=(Button) findViewById(R.id.button);
        timebutton=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        t1=(EditText) findViewById(R.id.editText2);
        t2=(EditText) findViewById(R.id.editText3);
        t3=(EditText) findViewById(R.id.editText4);
        v1=(TextView) findViewById(R.id.textView5);
        v2=(TextView) findViewById(R.id.textView6);
        v3=(TextView) findViewById(R.id.textView7);
        r1=(RadioButton) findViewById(R.id.radioButton);
        r2=(RadioButton) findViewById(R.id.radioButton2);
        r3=(RadioButton) findViewById(R.id.radioButton3);
        r4=(RadioButton) findViewById(R.id.radioButton5);
        r5=(RadioButton) findViewById(R.id.radioButton6);
        image=(ImageView) findViewById(R.id.imageView);
        date=(CalendarView) findViewById(R.id.calendarView);
        time=(TimePicker) findViewById(R.id.timePicker);


         set.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 chro1.setBase(SystemClock.elapsedRealtime());
                 chro1.start();
                 chro1.setTextColor(Color.BLUE);
                 if(b){
                     f1.setVisibility(View.VISIBLE);
                     l2.setVisibility(View.VISIBLE);

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
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(null,"인원을 입력하세요",Toast.LENGTH_SHORT).show();
                }

               else {
                    int su = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    double sum;
                    double hal;
                    double lastsum;
                    if (r1.isChecked()) {
                        sum = ((Integer.parseInt(s1) * 15000) + (Integer.parseInt(s2) * 12000) + (Integer.parseInt(s3) * 6000));
                        hal = sum * 0.05;
                        lastsum = sum - hal;
                        v1.setText("총명수:"+su);
                        v2.setText(String.format("할인금액 :%.1f", hal));
                        v3.setText(String.format("결제금액 :%.1f", lastsum));

                    }
                    if (r2.isChecked()) {
                        sum = ((Integer.parseInt(s1) * 15000) + (Integer.parseInt(s2) * 12000) + (Integer.parseInt(s3) * 6000));
                        hal = sum * 0.10;
                        lastsum = sum - hal;
                        v1.setText("총명수:"+su);
                        v2.setText(String.format("할인금액 :%.1f", hal));
                        v3.setText(String.format("결제금액 :%.1f", lastsum));

                    }

                    if (r3.isChecked()) {
                        sum = ((Integer.parseInt(s1) * 15000) + (Integer.parseInt(s2) * 12000) + (Integer.parseInt(s3) * 6000));
                        hal = sum * 0.20;
                        lastsum = sum - hal;
                        v1.setText("총명수:"+su);
                        v2.setText(String.format("할인금액 :%.1f", hal));
                        v3.setText(String.format("결제금액 :%.1f", lastsum));

                    }
                }

            }
        });

        timebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setVisibility(View.VISIBLE);
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.INVISIBLE);
            }
        });

        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                f2.setVisibility(View.VISIBLE);
                    date.setVisibility(View.VISIBLE);
                   time.setVisibility(View.INVISIBLE);
            }
        });
        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                f2.setVisibility(View.VISIBLE);
                date.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);

            }
        });
        date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                year=i;
                month=i1;
                day=i2;

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                String str2,str3;

                str2=Integer.toString(time.getCurrentHour());
                str3=Integer.toString(time.getMinute());

                Toast.makeText(null,(year+" "+month+" "+day+str2+":"+str3+"예약이 완료되었습니다"),Toast.LENGTH_SHORT).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.VISIBLE);
                l1.setVisibility(View.INVISIBLE);
            }
        });
    }
}
