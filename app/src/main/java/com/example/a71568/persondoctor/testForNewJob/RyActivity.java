package com.example.a71568.persondoctor.testForNewJob;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a71568.persondoctor.R;
import com.example.a71568.persondoctor.activity.BaseActivity;
import com.example.a71568.persondoctor.util.AppApplication;

import java.util.ArrayList;
import java.util.List;

public class RyActivity extends BaseActivity {
    private List<RecyTestBean> testList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ry);
        init();
        RecyclerView recyclerView=f(R.id.recy_test);
     //  LinearLayoutManager layoutManager=new LinearLayoutManager(this);
       // recyclerView.setLayoutManager(layoutManager);
        GridLayoutManager gm=new GridLayoutManager(AppApplication.getContextApp(),2);
        recyclerView.setLayoutManager(gm);
        RecyAdapter ra=new RecyAdapter(testList);
        recyclerView.setAdapter(ra);
    }

    private void init(){
        testList=new ArrayList<>();
        for(int i=0;i<4;i++){
            RecyTestBean recyTestBean=new RecyTestBean("测试",R.drawable.health_news_64);
            testList.add(recyTestBean);
        }
            }
private class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolderRy>{

    private List<RecyTestBean> testList;
    @Override
    public RecyAdapter.ViewHolderRy onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recy_test,parent,false);
        ViewHolderRy vry=new ViewHolderRy(view);
        return vry;
    }

    @Override
    public void onBindViewHolder(ViewHolderRy holder, int position) {
     RecyTestBean rtb=testList.get(position);
        holder.recy_image.setImageResource(rtb.getInageId());
        holder.recy_text.setText(rtb.getRecyText());
    }

    public RecyAdapter(List<RecyTestBean> testList) {
        this.testList = testList;
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    public class ViewHolderRy extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView recy_text;
        ImageView recy_image;
        public ViewHolderRy(View itemView) {
            super(itemView);
            recy_image=itemView.findViewById(R.id.recy_test_image);
            recy_text=itemView.findViewById(R.id.recy_test_text);//这里必须itemView
            recy_text.setOnClickListener(this);
            recy_image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.recy_test_image:
                    Toast.makeText(AppApplication.getContextApp(),"这是图片",Toast.LENGTH_SHORT).show();
                break;
                case R.id.recy_test_text:
                    Toast.makeText(AppApplication.getContextApp(),"这是文字",Toast.LENGTH_SHORT).show();
                    break;
                default :break;
            }
        }
    }
}
}
