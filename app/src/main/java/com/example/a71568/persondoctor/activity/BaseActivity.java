package com.example.a71568.persondoctor.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a71568.persondoctor.R;

/**
 * 申请定位
 */
public class BaseActivity extends FragmentActivity {
    public ImageView back,right;
    public TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        //getSupportActionBar().hide();
        initView();
    }
//对findview的泛型封装 可以推广到所有参考系
    protected <T extends View>T f(int id){
        return (T)findViewById(id);
    }
    private void initView(){
        back=f(R.id.tool_back);
        right=f(R.id.tool_right);
        tvName=f(R.id.activity_name);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    protected void setAcName(String name){
        tvName.setText(name);
    }
}
