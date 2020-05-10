package com.example.consonlidateactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseAcitvity {
    public static final String TAG = "FirstActivity";

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.e(TAG, this.toString());
        Log.e(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.activity_first);
        button1 = findViewById(R.id.button_1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
                //显示Intent
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);



                //隐式Intent action
//                Intent intent = new Intent("com.example.consonlidateactivity.ACTION_START");


                //action只能有一个，category 可以有多个
//                Intent intent = new Intent("com.example.consonlidateactivity.ACTION_START");
//                //添加一个新的category
//                intent.addCategory("com.example.consonlidateactivity.MY_CATEGORY");


                //访问网页
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://baidu.com"));

                //拨号页面
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("tel:10086"));


                //activity 之间传递信息
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("extra_data",data);

//                startActivity(intent);




                // activity 之间传递信息 并返回信息
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivityForResult(intent,1);

                //启动模式 standard
                //singleTop 检查是否在栈顶 若是则不创建否则创建新activity
                //singleTask 启动时系统会先在栈中查询是否有该活动实例，若有则直接使用，并把这个实例上面的活动统统出栈，如果没有，则重新创建该实例
                // singleInstance 将此模式下的activity单独放到一个返回栈中，并且这个栈中有且只有这一个activity f -> s -> t -> f   t,f同栈所以从t返回就到了f 再back 则退出

//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);

                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }
        });


        Button finish = findViewById(R.id.button_2);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //销毁当前活动 Activity
                finish();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, returnedData);
                }
                break;
                default:
                    break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //获取MenuInflater对象
        getMenuInflater().inflate(R.menu.main,menu);
        // true 表示允许创建的菜单显示出来
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this,"You clicked Rmove",Toast.LENGTH_SHORT).show();
                break;
                default:

        }
         return true;

    }
}
