package com.example.a71568.persondoctor.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a71568.persondoctor.R;
import com.example.a71568.persondoctor.util.AppApplication;
import com.example.a71568.persondoctor.util.TimeInvert;

/**
 * 本app 实现医疗看病 连接c 端病人或者独立执业医生 或者 b端的医生
 * 登录之前的一个activity 用于做几秒钟的广告，如果没有本地缓存账号密码自动登录的
 * 则跳转到loginActivity 去 若是有账号密码的 则直接跳到主界面
 * 3秒handler倒数延迟
 * 第二种方案也可以放好几个图片做滑动的viewpager
 */
public class BeforeActivity extends AppCompatActivity {

    public static final int COUNT = 3;
    public static int count=3;
    private static TextView lbText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforelogin);
        initView();
        // this.setAcName();
        TimeInvert.getInstance().etcx(count);
        //你看果然这里又是并行的问题

    }

    /**
     * 挺矛盾的 f()只提供给他继承的activity 没法作为一种能力 不声明的给予所有对象
    */
    private void initView() {
        lbText = (TextView) findViewById(R.id.lbtext);
    }

  public static  Handler handler = new Handler() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case COUNT:
                    count--;
                    lbText.setText(count + "");
                    if (count<=0){
                      Intent intent= new Intent( AppApplication.getContextApp(),LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        AppApplication.getContextApp().startActivity(intent);
                    }
                    break;
                default:
                    break;
            }
        }
    };
}