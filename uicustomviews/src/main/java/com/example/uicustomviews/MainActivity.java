package com.example.uicustomviews;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = MainActivity.this.getSupportActionBar();
        if (actionBar != null) {

            Log.e(TAG, "onCreate: " );
            actionBar.hide();
        }

        setContentView(R.layout.activity_main);
    }
}
