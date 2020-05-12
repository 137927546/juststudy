package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendNotice = findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notice:

                //过时
//                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                Notification notification = new NotificationCompat.Builder(this)
//                        .setContentTitle("This is content title")
//                        .setContentText("This is content text")
//                        .setWhen(System.currentTimeMillis())
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
//                        .build();
//                manager.notify(1,notification);

                createNofication();
                break;
                default:
                    break;
        }
    }

    private void createNofication(){

        //通过下面的 PendingIntent 可以实现点击notice跳转
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

        //channelId为本条通知的id
        int channelId = 1 ;
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder ;


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){        //Android 8.0适配
            NotificationChannel channel = new NotificationChannel(String.valueOf(channelId),
                    "channel_name",
                    NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(this,String.valueOf(channelId));
        }else{
            builder = new NotificationCompat.Builder(this);
        }
        builder.setContentTitle("this is content title")            //指定通知栏的标题内容
                .setContentText("this is content text")             //通知的正文内容
//                .setStyle(new NotificationCompat.BigTextStyle().bigText("this is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content textthis is content text"))//长段落显示
//                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.bq)))
                .setWhen(System.currentTimeMillis())                //通知创建的时间
                .setSmallIcon(R.drawable.ic_launcher_background)    //通知显示的小图标，只能用alpha图层的图片进行设置
//                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Lyra.ogg")))
//                .setDefaults(NotificationCompat.DEFAULT_SOUND|NotificationCompat.DEFAULT_VIBRATE)
//                .setVibrate(new long[]{0,1000,1000,1000})
//                .setLights(Color.GREEN,1000,1000)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background));
        //notice设置意图
        builder.setContentIntent(pi);
        //点击自动取消 一
        builder.setAutoCancel(true);

        //点击自动取消 二  8.0 之后取消不了待解决
//        manager.cancel(channelId);

        Notification notification = builder.build() ;
        //channelId为本条通知的id
        manager.notify(channelId,notification);
    }
}
