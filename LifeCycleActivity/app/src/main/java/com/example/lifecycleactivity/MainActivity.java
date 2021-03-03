package com.example.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Life Cycle events", "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Life Cycle events", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Life Cycle events", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Life Cycle events", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Life Cycle events", "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("Life Cycle events", "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Life Cycle events", "onDestroy: ");
    }
}