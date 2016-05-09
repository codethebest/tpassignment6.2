package com.example.leo.tpassignment61;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.leo.tpassignment61.services.MyService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startMethod(View view)
    {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("message","This is a message test");
        startService(i);
    }

    public void stopMethod(View view)
    {
        Intent i = new Intent (this,MyService.class);
        stopService(i);
    }
}
