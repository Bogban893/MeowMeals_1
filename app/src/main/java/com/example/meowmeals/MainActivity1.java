package com.example.meowmeals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main1);
        setContentView(new GameView(this));

    }
}