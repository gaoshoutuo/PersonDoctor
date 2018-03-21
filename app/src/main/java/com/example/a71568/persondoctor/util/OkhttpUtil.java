package com.example.a71568.persondoctor.util;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 71568 on 2017/12/23.
 * 是时候给自己封装一个http工具类
 */

public class OkhttpUtil {
    private static OkHttpClient okHttpClient=new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.SECONDS)
            .readTimeout(10000, TimeUnit.SECONDS)
            .writeTimeout(10000, TimeUnit.SECONDS)
            .build();
    /**
     * get
     */
     public static void getOkhttp(final String url){
         //下次再也不用这么丑陋的实现方式了  线程池规范一点   线程数据交给handler了
         String returnjson=null;
         new Thread(new Runnable() {
             @Override
             public void run() {
                 Request request=new Request.Builder().url(url).build();
                 //更复杂化的参数应该去了解一下
                 String json=null;
                 try {
                     Response response=okHttpClient.newCall(request).execute();
                     // response.body().byteStream()
                     json =response.body().string().toString();
                     Log.e("json",json);
                     //Message msg=Message.obtain();
                     Message msg=new Message();
                     msg.what=BeanBean.MENU1;
                     msg.obj=json;
                    //HandlerUtil.handler.sendMessage(msg);
                     HandlerUtil.handler.sendMessage(msg);

                     //Toast.makeText(AppApplication.getContextApp(),json,Toast.LENGTH_SHORT).show();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }).start();
     }
    /**
     * post
     */
    public static void postOkhttp(){

    }
}
