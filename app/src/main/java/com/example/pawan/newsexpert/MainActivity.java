package com.example.pawan.newsexpert;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*os will come here....logic to close after 5 seconds
        open home screen
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //os will come here after 2000 milli second
                finish();
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        }, 3000);
    }
}
