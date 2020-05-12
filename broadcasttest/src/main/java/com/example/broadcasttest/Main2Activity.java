package com.example.broadcasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

/**
 * 标准广播
 */
public class Main2Activity extends AppCompatActivity {

//    private MyBroadcastReceiver myBroadcastReceiver;
//    private IntentFilter intentFilter;

    public static final String TAG = "Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        myBroadcastReceiver = new MyBroadcastReceiver();
//        intentFilter = new IntentFilter("com.example.broadcasttest.MY_BROADCAST");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
                // 下面这句话很重要，8.0以后必须要加这段代码不然收不到广播！！！
                intent.setComponent(new ComponentName("com.example.broadcasttest",//包名。
                       "com.example.broadcasttest.MyBroadcastReceiver"));// MyBroadcastReceiver文件所在路径
                sendBroadcast(intent);
                //此处可在其他AntoherBroadcastReceiver中的广播接收器中接收到
                Intent intent1 = new Intent("com.example.broadcasttest.MY_BROADCAST");
                intent1.setComponent(new ComponentName("com.example.anotherbroadcastreceiver",//包名。
                        "com.example.anotherbroadcastreceiver.AnotherBroadcastReceiver"));
                sendBroadcast(intent1);
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        registerReceiver(myBroadcastReceiver,intentFilter);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(myBroadcastReceiver);
//    }
}
