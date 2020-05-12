package com.example.uilayouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *     android:orientation="horizontal" |vertical
     *     android:layout_gravity="bottom" |center_vertical |top | right | left... 相对父容器
     *     android:layout_weight="1"    权重
     *
     *     LinearLayout  RelativeLayout  FrameLayout  ***ConstraintLayout+Guideline  PercentFrameLayout(android studio 3.5 java percent弃用)
     *
     */
}
