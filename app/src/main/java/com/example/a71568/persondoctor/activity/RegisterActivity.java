package com.example.a71568.persondoctor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a71568.persondoctor.R;

/**
 * 获取验证码之后要变成60秒的倒计时
 * 倒计要单独写出来。。
 */

public class RegisterActivity extends BaseActivity {
EditText mobileEdit,passwordEdit,verifivationEdit;
    TextView register,verify;
    //倒计时就是需要拿来 drwaable的right xml填入 然后改变xml中textView的值配合发送验证码按钮 enable
    //其实也不需要是短信 我的socketio也可以拿来发通知为短信
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        f(R.id.pid_l3).setVisibility(View.VISIBLE);
        initView();
    }
    private void initView(){
        mobileEdit=f(R.id.register_mobile);
        passwordEdit=f(R.id.register_password);
        verifivationEdit=f(R.id.register_verification);
        register=f(R.id.register);
        verify=f(R.id.send_verify);
        register.setOnClickListener(listener);
        verify.setOnClickListener(listener);
    }
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           switch(view.getId()){
               case R.id.register:
                   //注册 向后台数据库申请
                   break;
               case R.id.send_verify:
                   //向手机号发送验证码
                   break;
               default:break;
           }
        }
    };
}
