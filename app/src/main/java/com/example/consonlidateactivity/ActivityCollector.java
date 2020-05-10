package com.example.consonlidateactivity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liubo on 2020/5/10
 * activity管理器
 */
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity acitivy){
        activities.remove(acitivy);
    }

    public static void finishAll(){


//        遍历数组的简单方式
//        /* 建立一个数组 */
//        int[] integers = {1， 2， 3， 4};
//
//        /* 开始遍历 */
//        for (int i : integers) {
//            System.out.println(i); /* 依次输出“1”、“2”、“3”、“4” */
//        }
//
        for(Activity acitivty : activities){
            if (!acitivty.isFinishing()){
                acitivty.finish();
            }
        }
        activities.clear();

//        //杀掉当前进程
//        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
