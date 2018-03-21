package com.example.a71568.persondoctor.util;


import android.content.Intent;
import android.os.Message;


import com.example.a71568.persondoctor.activity.BeforeActivity;
import com.example.a71568.persondoctor.activity.LoginActivity;
import com.example.a71568.persondoctor.activity.RegisterActivity;

import java.util.List;

/**
 * Created by 71568 on 2017/12/10.
 */

public class TimeInvert {
    private int count=0;
    public static final int COUNT = 3;
    public void etcx(final int x){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    count++;
                    Thread.sleep(1000);
                    Message msg = Message.obtain();
                    msg.what = COUNT;
                    BeforeActivity.handler.sendMessage(msg);
                    if(count<x){
                        this.run();
                    }
                    if(x==3){//是倒计时 Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?
                       // AppApplication.getContextApp().startActivity(new Intent(AppApplication.getContextApp(), LoginActivity.class));
                    }
                    //职责不要弄混了 跳转activity是activity应该做的事情
                    if(x==360){//是每个病人看病最大时长
                       // AppApplication.getContextApp().startActivity(new Intent(AppApplication.getContextApp(), LoginActivity.class));
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 单例
     * @return
     */
    private static TimeInvert ti;
    public static TimeInvert getInstance(){
        if(ti==null) {
            ti = new TimeInvert();
        }
        return ti;
    }
}
