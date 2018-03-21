package com.example.a71568.persondoctor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a71568.persondoctor.R;
import com.example.a71568.persondoctor.adapter.SelectActivityAdapter;
import com.example.a71568.persondoctor.bean.BBB;
import com.example.a71568.persondoctor.bean.DoctorInfo;
import com.example.a71568.persondoctor.util.ParseJsonUtil;

import java.util.ArrayList;
import java.util.List;

public class SelectDoctor extends BaseActivity {
//卡片式布局 并且双行text 姓名 年龄 职位

    private RecyclerView recyclerView;
    private List<BBB>doctorInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor);
        initView();
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        SelectActivityAdapter selectActivityAdapter=new SelectActivityAdapter(doctorInfoList,this);
        recyclerView.setAdapter(selectActivityAdapter);
    }

    private void initView(){
        recyclerView=f(R.id.select_doctor);
      String xxs=  getIntent().getStringExtra("jsondata");
        ParseJsonUtil.ParseJsonArray(xxs);
        setCard();
    }
    /*
    此处应该有json 至于解析json  mainThread放一个progressBar 违心的提高用户体验
     */
    private void setCard(){
        doctorInfoList= ParseJsonUtil.listObj;

    }
}
