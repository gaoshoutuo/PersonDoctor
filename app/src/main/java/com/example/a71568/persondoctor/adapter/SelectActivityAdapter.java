package com.example.a71568.persondoctor.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a71568.persondoctor.R;
import com.example.a71568.persondoctor.bean.BBB;
import com.example.a71568.persondoctor.bean.DoctorInfo;
import com.example.a71568.persondoctor.util.AppApplication;

import java.util.List;

/**
 * Created by 71568 on 2017/12/25.
 */

public class SelectActivityAdapter extends RecyclerView.Adapter <SelectActivityAdapter.ViewHolder>{
    private List<BBB>lists;
    private Activity activity;
    private int position=0;

    public SelectActivityAdapter(List<BBB> lists, Activity activity) {
        this.lists = lists;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //如果要对Adapter做封装，是对view泛  ，抽象的话我估计是全局流程自己走
        View view= LayoutInflater.from(activity).inflate(R.layout.item_select_doctor,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view,position);
        viewHolder.doctorPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //用position 拼一个url  并跳入一个webwiew webrtc的Activity中
                Toast.makeText(AppApplication.getContextApp(),viewHolder.geti()+"",Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DoctorInfo doctorInfo= (DoctorInfo) lists.get(position);
       holder.doctorIntelligence.setText(doctorInfo.getDoctorIntelligence());
        Glide.with(activity).load(doctorInfo.getPicUrl())  .placeholder(R.drawable.ic_default_image)
                .error(R.drawable.ic_default_image).into(holder.doctorPic);
       this.position=position+1;
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        private TextView doctorIntelligence;
        private ImageView doctorPic;
        private int position;


        public int geti() {
            return position;
        }

        //我估计官方的那个position应该不准 我自己搞一个
        public ViewHolder(View itemView,int position) {
            super(itemView);
            cardView=(CardView)itemView;
            doctorIntelligence=itemView.findViewById(R.id.doctor_intelligence);
            doctorPic=itemView.findViewById(R.id.doctor_pic);
            this.position=position;
        }
    }
    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
}
