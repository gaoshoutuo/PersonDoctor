package com.example.a71568.persondoctor.activity;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.a71568.persondoctor.R;
import com.example.a71568.persondoctor.bean.CommonMedicineBean;
import com.example.a71568.persondoctor.util.DialogUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonMedicineActivity extends BaseActivity implements View.OnClickListener{
    private RecyclerView commonMedicineRecy;
    private ArrayList<CommonMedicineBean>commonMedicineList=new ArrayList<>();
    private int layoutValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_medicine);
        commonMedicineRecy=f(R.id.common_medicine_recy);
        RecyclerView.OnScrollListener scrollListener=getScrollListener(0);
        LinearLayoutManager lm=new LinearLayoutManager(this);
        commonMedicineRecy.setLayoutManager(lm);
        layoutValue=R.layout.item_common_activity;
        initCMList();
        CMAdapter cmAdapter=new CMAdapter(commonMedicineList,layoutValue,this);
        //commonMedicineRecy.addOnScrollListener(scrollListener);
        commonMedicineRecy.setAdapter(cmAdapter);
    }

    public void initCMList(){
       // commonMedicineList.add(new CommonMedicineBean());
        for(int i=1;i<10;i++){
            CommonMedicineBean cmb=new CommonMedicineBean
                    (20.5,"利他林",R.drawable.doctor_info_64,3);

            commonMedicineList.add(cmb);
        }
    }

    private RecyclerView.OnScrollListener getScrollListener(int position){
        RecyclerView.OnScrollListener scrollListener= new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();//获取LayoutManager
                if (manager != null && manager instanceof LinearLayoutManager) {
                    //第一个可见的位置
                    int firstPosition = ((LinearLayoutManager) manager).findFirstVisibleItemPosition();
                    //如果 dx>0 则表示 右滑 ,dx<0 表示 左滑,dy <0 表示 上滑, dy>0 表示下滑
                    if (dx > 0) {
                        //右划监听
                        //topBar.setVisibility(firstPosition>1 ? View.VISIBLE : View.GONE);
                    } else {
                        //左划监听
                        //topBar.setVisibility(firstPosition==0 ? View.GONE : View.VISIBLE);
                    }

                    if (dy < 0) {
                        //上滑监听
                        //topBar.setVisibility(firstPosition>1 ? View.VISIBLE : View.GONE);
                    } else {
                        //下滑监听
                        //topBar.setVisibility(firstPosition==0 ? View.GONE : View.VISIBLE);
                    }
                }
            }

        };
        return scrollListener;
    }

    @Override
    public void onClick(View view) {

    }

    class CMAdapter extends RecyclerView.Adapter<CMAdapter.CMViewHolder> {
        private ArrayList<CommonMedicineBean>commonMedicineList;
        private int layoutValue;
        private Activity activity;
        private  View.OnScrollChangeListener sListener;
        private int work_mode=0;
        private int touchPosition;

        @RequiresApi(api = Build.VERSION_CODES.M)
        private void setItemViewScrollListener(){
            sListener=new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    HashMap<Integer,Object>map=(HashMap)view.getTag();
                    if (i2-i>100){//左滑 右滑
                        //work_mode=1;
                        initRightView((CMViewHolder) map.get(2));
                        CMAdapter.this.notifyItemChanged((int)map.get(1));

                    }else if(i2-i>-100){
                        //work_mode=2;
                        initLeftView((CMViewHolder) map.get(2));
                        CMAdapter.this.notifyItemChanged((int)map.get(1));
                    }
                    //touchPosition=view.get;
                }
            };

        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public CMViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            /*if(sListener==null){
                setItemViewScrollListener();
            }*/
            View view= LayoutInflater.from(activity).inflate(layoutValue,parent,false);
            //view.setOnScrollChangeListener(sListener);
            CMViewHolder holder=new CMViewHolder(view);
            return holder;
        }

        @Override
        public int getItemCount() {
            return commonMedicineList.size();
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onBindViewHolder(CMViewHolder holder, int position) {

            if(work_mode==0){ //1正常模式


                holder.view.setOnScrollChangeListener(sListener);
                CommonMedicineBean cmb=commonMedicineList.get(position);
                holder.medicineImage.setBackgroundResource(cmb.getMedicineImage());
                holder.medicinePrice.setText(cmb.getPrice()+"");
                holder.medicineName.setText(cmb.getMedicineName()+"");
                holder.medicineCount.setText(cmb.getMedicineCount()+"");
                final String cmName=cmb.getMedicineName()+"";
                holder.medicineCount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {//弹出卖出 数量  进货 数量 这个选项
                        DialogUtil.getInstance().cMDialog(CommonMedicineActivity.this,cmName);
                    }
                });
                //holder.view.setTag(position);
                HashMap<Integer,Object>map=new HashMap<>();
                map.put(1,position);
                map.put(2,holder);
                holder.view.setTag(map);
            }
            /*else if(work_mode==1&&position==1){//2替换模式 左滑  使用
                work_mode=0;
                View leftView;
                initRightView(holder);
                this.notifyItemChanged(position);
            }else if(work_mode==2&&position==1){//2替换模式 右滑  使用另一个view来替代
                work_mode=0;
                View rightView;
                initLeftView(holder);
                this.notifyItemChanged(position);
            }*/

        }

        private CMViewHolder initLeftView(CMViewHolder leftHolder){//右滑
            //View leftView=LayoutInflater.from(activity).inflate(layoutValue,null,false);
            //CMViewHolder leftHolder=new CMViewHolder(leftView);
            //leftHolder.medicinePrice.setVisibility(View.GONE);
            leftHolder.medicineCount.setVisibility(View.GONE);
            leftHolder.medicineIn.setVisibility(View.VISIBLE);
            return leftHolder;
        }

        private CMViewHolder initRightView(CMViewHolder rightHolder){//左滑
            //View rightView=LayoutInflater.from(activity).inflate(layoutValue,null,false);
           // CMViewHolder rightHolder=new CMViewHolder(rightView);
            rightHolder.medicineImage.setVisibility(View.GONE);
            rightHolder.medicineDe.setVisibility(View.VISIBLE);
            return rightHolder;
        }

        public CMAdapter(ArrayList<CommonMedicineBean> commonMedicineList, int layoutValue, Activity activity) {
            this.commonMedicineList = commonMedicineList;
            this.layoutValue = layoutValue;
            this.activity = activity;
        }

        class CMViewHolder extends RecyclerView.ViewHolder{
            public ImageView medicineImage;
            public TextView medicinePrice,medicineCount,medicineName;
            public Button medicineDe,medicineIn;
            public View view;
            public CMViewHolder(View itemView) {
                super(itemView);
                medicineImage=itemView.findViewById(R.id.common_medicine_image);
                medicinePrice=itemView.findViewById(R.id.common_medicine_price);
                medicineCount=itemView.findViewById(R.id.common_medicine_count);
                medicineName=itemView.findViewById(R.id.common_medicine_name);
                medicineDe=itemView.findViewById(R.id.common_medicine_de);
                medicineIn=itemView.findViewById(R.id.common_medicine_in);
                view=itemView;
            }
        }

    }
}
