package com.example.uiwidgettest;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * UI
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *          android:gravity="center"
         *          android:textSize="24sp"
         *          android:textColor="#00ff00"
         *
         *          Button:
         *                  android:textAllCaps="false" text中的字体是否全部大写  默认true  大写
         */


        Button button = findViewById(R.id.button);
        //监听 方案一
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //在此处添加逻辑
//
//            }
//        });
        //监听 方案二
        button.setOnClickListener(this);

        editText = findViewById(R.id.edit_text);
        imageView = findViewById(R.id.image_view);
        //style="?android:progressBarStyleHorizontal"  变为加载条
        progressBar = findViewById(R.id.progress_bar);

//        progressBar.setMax(1000);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //在此处添加逻辑
//                String inputText = editText.getText().toString();
//                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();

                //代码设置图片
//                imageView.setImageResource(R.drawable.xiaoqing);

//                if (progressBar.getVisibility() == View.GONE) {
//                        progressBar.setVisibility(View.VISIBLE);
//                } else {
//                    progressBar.setVisibility(View.GONE);
//                }


//                int progress = progressBar.getProgress();
//                progress = progress + 10;
//                progressBar.setProgress(progress);

//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("This is Dialog");
//                dialog.setMessage("Something important.");
//                dialog.setCancelable(true);
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,"PositiveButton",Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,"NegativeButton",Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.show();


                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                //不能点击 或者  返回取消ProgressDialog
                progressDialog.setCancelable(false);
                progressDialog.show();
                break;
                default:
                    break;
        }
    }
}
