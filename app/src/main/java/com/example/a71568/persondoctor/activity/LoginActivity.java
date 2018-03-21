package com.example.a71568.persondoctor.activity;

import android.app.IntentService;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a71568.persondoctor.R;

public class LoginActivity extends BaseActivity {
    TextView login;
    public static final int USERINFO=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setAcName("登录");
    }
    private void initView(){
        login= f(R.id.login);
        login.setOnClickListener(listener);
    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.login:
                    Intent intent1=new Intent(LoginActivity.this,MenuActivity.class);
                    startActivityForResult(intent1,USERINFO);
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode!=0){
           if(resultCode==101){

           }
       }
    }
    /**要想写的时候就能写，我现在对于 okhttp 以及http仍然不熟悉。
     * 此处应该使用http工具去请求 某个地址 然后业务系统返回手机号码的那些信息
     * 病历这些记录在本地数据库上面
     * 一切都要自己写一遍再去评估别人写的工具
     * 发现了 没有后台 前台就是一个屁。
     */
}
