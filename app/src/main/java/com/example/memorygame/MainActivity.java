package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {



    int [] id = {R.id.i1,R.id.i2,R.id.i3,R.id.i4,R.id.i5,R.id.i6,R.id.i7,R.id.i8,
            R.id.i9,R.id.i10,R.id.i11,R.id.i12,R.id.i13,R.id.i14,R.id.i15,R.id.i16};
    int[] image = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8};
    int [][] store = {{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
    int score=0,i=0;
    int []temporary={-1,-1};
    int []tempid={-1,-1};
    int []check={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int ch=0,checker=1;

    
    public void tap(View view){
        i++;
        if(i==1){
            ImageView img = (ImageView) view;
            int info = img.getId();
            for (int s=0;s<=15;s++){
                if(store[s/2][s%2]==info){
                    img.setImageResource(image[s/2]);
                    temporary[0]=s/2;
                    tempid[0]=info;
                }
            }
        }
        else if(i==2){
            i=0;
            ImageView img = (ImageView) view;
            int info = img.getId();
            for (int s=0;s<=15;s++){
                if(store[s/2][s%2]==info){
                    img.setImageResource(image[s/2]);
                    temporary[1]=s/2;
                    tempid[1]=info;
                }
            }
            for(int a=0;a<=15;a++){
                ImageView r = findViewById(id[a]);
                r.setClickable(false);
            }
            if(temporary[0]==temporary[1] && tempid[0] != tempid[1]){
                score+=10;
                check[ch]= tempid[0];
                check[ch+1]=tempid[1];
                ch=ch+2;
                TextView txt = findViewById(R.id.maintxt);
                String sc = String.valueOf(score);
                txt.setText(sc);
                ImageView i1 = findViewById(tempid[0]);
                ImageView i2 = findViewById(tempid[1]);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        i1.setImageResource(R.drawable.correct);
                        i2.setImageResource(R.drawable.correct);
                        for(int a=0;a<=15;a++){
                            ImageView r = findViewById(id[a]);
                            for(int j=0;j<=15;j++){
                                if(id[a]==check[j]){
                                    checker=0;
                                }
                            }
                            if(checker==1){
                                r.setClickable(true);
                            }
                            checker=1;

                        }
                    }
                }, 500);


            }
            else{
                ImageView i1 = findViewById(tempid[0]);
                ImageView i2 = findViewById(tempid[1]);
                new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    i1.setImageResource(R.drawable.color);
                    i2.setImageResource(R.drawable.color);
                    for(int a=0;a<=15;a++){
                        ImageView r = findViewById(id[a]);
                        for(int j=0;j<=15;j++){
                            if(id[a]==check[j]){
                                checker=0;
                            }
                        }
                        if(checker==1){
                            r.setClickable(true);
                        }
                        checker=1;

                    }
                }
            }, 500);

            }
            temporary[0]=-1;
            temporary[0]=-1;


        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Integer[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15};

        List<Integer> intList = Arrays.asList(intArray);

        Collections.shuffle(intList);

        intList.toArray(intArray);
        //constraintLayout = (ConstraintLayout) findViewById(R.id.constraint);
        for(int i=0;i<=15;i++){

            ImageView i1 =findViewById(id[intArray[i]]);
            i1.setImageResource(image[i/2]);
            store[i/2][i%2]=id[intArray[i]];


        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView tv = findViewById(R.id.textView3);
                tv.setText("2");
                timer2();

            }
        }, 1000);


    }

    public void timer2(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView tv = findViewById(R.id.textView3);
                tv.setText("1");
                timer1();


            }
        }, 1000);

    }
    public void timer1(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int a=0;a<=15;a++){
                    ImageView r = findViewById(id[a]);
                    r.setImageResource(R.drawable.color);
                }
                TextView tv = findViewById(R.id.textView3);
                tv.setText("Lets Go");
                lasttimer();
                //poptimer();
                prog();

            }
        }, 1000);

    }
    //PopupWindow popupWindow;
    //LayoutInflater layoutInflater;
    //ConstraintLayout constraintLayout;

   /* public  void poptimer(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.test,null);
                popupWindow =new PopupWindow(container,800,800,true);
                popupWindow.showAtLocation(constraintLayout, Gravity.NO_GRAVITY,150,600);


            }
        }, 30000);

    }*/
    public  void lasttimer(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView tv = findViewById(R.id.textView3);
                tv.setVisibility(View.INVISIBLE);

            }
        }, 500);

    }

    int counter =100;

    public void prog()
    {

        ProgressBar pb =findViewById(R.id.pb);

        final Timer t =new Timer();
        TimerTask tt =new TimerTask() {
            @Override
            public void run() {
                counter--;
                if(counter<=0){
                    t.cancel();
                }
                //Log.d("HARDIK", String.format("Value of Counter is: %d", counter));
                pb.setProgress(counter);

            }
        };
        t.schedule(tt,0,300);
    }


}