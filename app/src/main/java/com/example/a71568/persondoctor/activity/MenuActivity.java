package com.example.a71568.persondoctor.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.a71568.persondoctor.R;
import com.example.a71568.persondoctor.adapter.MenuGridviewAdapter;
import com.example.a71568.persondoctor.bean.MenuBean;
import com.example.a71568.persondoctor.testForNewJob.RyActivity;
import com.example.a71568.persondoctor.util.HandUtil;
import com.example.a71568.persondoctor.util.HandlerUtil;
import com.example.a71568.persondoctor.util.OkhttpUtil;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends BaseActivity {
    /**
     * 此处放9大功能
     * 专门搞个图片轮播吧 在上面轮播广告也好还是别的 总之也能为我家增加客流
     * 也可以跟一些诊所或者卫生院合作 把病患推荐过去挂针
     * 视频对话 我要看病
     * 病历
     * 健康资讯  新闻
     * 医生给自己打广告 我妈发朋友圈这么low的 在这里面就解决了
     * 常用特效药 介绍  便宜又还用 注意别用多了 有耐药性
     * 电商支付  这一块是重点 数据也要安全
     * 医生介绍 把医生资历挂上
     * 检查更新
     * 通知公告
     * 我的信息 放在侧边栏
     * 至于报告介绍 就诊历史 预约挂号 排队叫号 便捷寻医都需要相关医院支持以及数据支持
     * 我后台数据也很宝贵  对于常用药要先统计到数据库里 形成药的表 在根据开药对其加一，总之要求医生对于  某月开药药库
     * 妈个鸡要不要vpn我想一想，然后便捷的刷医保卡是最好的，妈个鸡的在线支付看好病了  药怎么送过去
     * 疾病的种类如何归类  在做成表，我的要求是 谁（医生）给（病人）开什么（药）因为什么病  病人信息，价格 时间
     * 做大再农村包围城市，星星火燎原
     *还要深入的去跟各种医生聊天做出贴近的产品
     * 该生活号开通后，成都市各级医保定点医院及药店将集中入驻。而市民只要打开支付宝搜索生活号“成都智慧医保”，
     * 即可享受各家入驻医院的挂号、医保及自费缴费、查报告等一系列功能，同时，在入驻的药店购药，市民在“成都智慧医保”
     * 生活里点击药店支付，即可生成二维码支付，完成医保结算   刷医保得药政府配合
     * @param savedInstanceState
     * 要么侧边栏 要么再搞一个我的信息  就可以了
     *
     * 开发高级会员 普通会员 插队功能 毕竟妈妈只有一个 不然呢拿两个账号两个手机同时看吗  我手上掌握自动化技术 让谁失业就失业
     *
     *
     */

    private GridView gridView;
    private ViewPager viewPager;
    private int width;
    private List<MenuBean> listMap=new ArrayList<>();
    private int[]gridviewIcon={R.drawable.seeill,R.drawable.illhistory_64,R.drawable.health_news_64,R.drawable.medicine_64,
    R.drawable.update_64,R.drawable.doctor_info_64,R.drawable.notify_64,R.drawable.more_64,R.drawable.suggest_64};
    private String[]gridviewText={"我要看病","病历","健康资讯","常用神药","检查更新","医生简介","通知公告","查看更多","意见与建议"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setAcName("功能菜单");
        initView();
        MenuGridviewAdapter menuGridviewAdapter=new MenuGridviewAdapter(listMap,3,gridView,clickListener);
        gridView.setAdapter(menuGridviewAdapter);
    }

    private void initView(){
        gridView=f(R.id.menu_gridview);
       // viewPager=f(R.id.myviewpager1);
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        width=dm.widthPixels/3;
        gridView.setColumnWidth(width);
        gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        gridView.setOnItemClickListener(clickListener);
        initListMap();
    }
    private void initListMap(){
        for(int i=0;i<gridviewIcon.length;i++){
            MenuBean mb=new MenuBean(gridviewIcon[i],gridviewText[i]);
            listMap.add(mb);
        }
    }
private AdapterView.OnItemClickListener clickListener=new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    switch (i){
        case 0:
            packToast(0);
            //我懂了你为啥报错了 这是并行的  怪不得
            OkhttpUtil.getOkhttp("http://176.122.185.2/picture/doctor_intelligence.json");


            // 这样不就拿到了吗只不过过程不是很美观 设计原则不是很准守  重复了 想startActivityForResult也封装
            break;
        case 1:
            packToast(1);
            startActivity(new Intent(MenuActivity.this, RyActivity.class));
            break;
        case 2:
            packToast(2);
            break;
        case 3:
            packToast(3);
            break;
        case 4:
            packToast(4);
            break;
        case 5:
            packToast(5);
            break;
        case 6:
            packToast(6);
            break;
        case 7:
            packToast(7);
            break;
        case 8:
            packToast(8);
            break;
        default:break;
    }
    }
};
    /**
     * 按数组索引 封装一个toast
     *
     */
    private void packToast(int i){
        Toast.makeText(this,gridviewText[i],Toast.LENGTH_SHORT).show();
    }
}
