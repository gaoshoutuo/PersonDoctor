package com.example.a71568.persondoctor.util;

import com.example.a71568.persondoctor.bean.BBB;
import com.example.a71568.persondoctor.bean.DoctorInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 71568 on 2017/12/25.
 * 静态方法必然导致内存膨胀  调用静态方法外面的非静态是随类初始化。。。
 *
 *解析json避免重复 初始化喜碧在里头进行  或者是判断结构直接去掉
 */

public class ParseJsonUtil {
    public static List<BBB> listObj;
    public static void ParseJsonArray(String xxs){
        listObj=new ArrayList<>();
        try {
            JSONArray ja=new JSONArray(xxs);
            for (int i=0;i<ja.length();i++){
                JSONObject jb=ja.getJSONObject(i);
                String jpic=jb.getString("doctor_pic");
                String jinfo=jb.getString("doctor_intelligence");
                DoctorInfo doctorInfo=new DoctorInfo(jpic,jinfo);
                listObj.add(doctorInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
