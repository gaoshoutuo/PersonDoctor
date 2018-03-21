package com.example.a71568.persondoctor.util;

import android.os.Handler;
import android.os.Message;

/**
 * Created by 71568 on 2017/12/25.
 * 例如把这个类抽象，不得不实现他的getMsg抽象方法返回值作为
 * 诶 又被这一环给阻挠了   抽象方法没有方法体 不能具体的  只有interface的 default方法可以助我
 * 我有想到了 就是变量传递而已   记住形参是外界的  传到方法里被使用，必然自身也会发生变化
 *
 * 要考察相应的应用抽象总结出其中的本质与共性  动手尝试书写自己的轮子   工具写出来也要教别人怎么用的 老用别人的轮子
 * 总觉得有些封装变量交换看不到很蛋疼
 */

public abstract class HandUtil extends Handler {
    public static Message msg;
    public abstract Message getData(String xxs);

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case BeanBean.MENU1:
                HandUtil.msg=msg;
                break;
            default:break;
        }
    }
}
