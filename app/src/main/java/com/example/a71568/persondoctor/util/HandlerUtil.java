package com.example.a71568.persondoctor.util;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.a71568.persondoctor.activity.MenuActivity;
import com.example.a71568.persondoctor.activity.SelectDoctor;

/**
 * Created by 71568 on 2017/12/23.
 * 写java的时候老是想着吧一些功能独立出去 写成工具类 抽象类 或者接口 而写c#则没有这种担心，c#果然闷声发大财
 * 所谓工具就是全局调用  这个handler集成所有
 * @author zth
 * 一个方法要成为工具 必须是静态的方便只知类名全局调用，可也会使变量必须静态化，知道程序运行结束这内存才能释放，这不gc
 *
 * 其实我理解错了  handler大概只对本类传数据有效 所以handler已经是一个类了  我要让他成为抽象接口或者抽象类似乎更加合适
 */

public class HandlerUtil {
    public static Message getMsg() {
        return msg;
    }

    private static Message msg;

    public static Handler handler=new Handler(AppApplication.getContextApp().getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                //别用魔法值
             /*   case 1:
                    break;*/
                case BeanBean.MENU1:

                    String xxs= (String)msg.obj;
                    Intent intentSelect=new Intent( AppApplication.getContextApp(),SelectDoctor.class);
                    intentSelect.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intentSelect.putExtra("jsondata",xxs);
                    AppApplication.getContextApp().startActivity(intentSelect);
                    break;

                default:break;
            }
        }
    };

}
