package com.example.a71568.persondoctor.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a71568.persondoctor.R;
import com.example.a71568.persondoctor.bean.MenuBean;
import com.example.a71568.persondoctor.util.AppApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 71568 on 2017/12/10.
 */

public class MenuGridviewAdapter extends BaseAdapter{
 //  private List<Map<String,Object>> listMap=new ArrayList<>();
    private AdapterView.OnItemClickListener clickListener;
    private List<MenuBean> listMap;
    private int rowCount;
    private GridView grw;
    @Override
    public int getCount() {
        return listMap.size();
    }

    @Override
    public Object getItem(int i) {
        return listMap.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 先给出view
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MenuBean mb=listMap.get(i);
        ViewHolder viewHolder;
        View viewR=view;
        if(viewR==null){
            viewR= LayoutInflater.from(AppApplication.getContextApp()).inflate(R.layout.item_menugrid,viewGroup,false);
            viewHolder=new ViewHolder();
            viewHolder.iv1=viewR.findViewById(R.id.itemgrid_iv);
            viewHolder.tv1=viewR.findViewById(R.id.itemgrid_tv);
            viewR.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) viewR.getTag();
        }

       // viewHolder.iv1.setImageResource(mb.getPicId());
        viewHolder.iv1.setImageResource(mb.getPicId());
       viewHolder.tv1.setText(mb.getMenuName());

        AbsListView.LayoutParams param = new AbsListView.LayoutParams(
                grw.getColumnWidth(),
                grw.getHeight()/rowCount);
        viewR.setLayoutParams(param);
        return viewR;
    }
    public MenuGridviewAdapter(List<MenuBean> listMap, int rowCount, GridView grv, AdapterView.OnItemClickListener clickListener){
        this.listMap=listMap;
        this.rowCount=rowCount;
        this.grw=grv;
        this.clickListener=clickListener;
    }

    static class ViewHolder{
        ImageView iv1;
        TextView tv1;

    }
}
