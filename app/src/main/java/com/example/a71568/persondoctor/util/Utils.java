package com.example.a71568.persondoctor.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.example.a71568.persondoctor.bean.MedicineInfoBean;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;

public class Utils {
    /**
     * 根据图片名称获取图片资源id
     * @param activity
     *
     * @param imageName
     * @return
     */
    public static int getResourceIdWthName(Activity activity, String imageName){
        Context ctx=activity.getBaseContext();
        int resouceId=activity.getResources().getIdentifier(imageName,"drawable",ctx.getPackageName());
        return resouceId;
    }

    //两种单例的实践重复写


    /**
     * 文件名读取xmlStr
     * @param resources
     * @param filename
     * @return
     */
    public static String getFileString(Resources resources, String filename){
        StringBuilder sb= new StringBuilder();
        try {
            InputStream is = resources.getAssets()
                    .open(filename);

            int len=0;
            byte []bytes=new byte[8000];

            while ((len=is.read(bytes))!=-1){
                sb.append(new String(bytes,0,len));
            }
            is.close();

            //Bitmap bm = BitmapFactory.decodeStream(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static ArrayList<MedicineInfoBean> xmlParse(String xmlStr){
        //MedicineInfoBean[] mArray=new MedicineInfoBean[25];
        ArrayList<MedicineInfoBean>list=new ArrayList<>();
        MedicineInfoBean bean=null;int id=0;
        try {
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            XmlPullParser parser=factory.newPullParser();
            parser.setInput(new StringReader(xmlStr));
            int eventType=parser.getEventType();
            //int eventType = parser.next();
            while(eventType!=XmlPullParser.END_DOCUMENT){
                int price=0;int cost=0;String mName=null;int profit=0;String imageName=null;
                switch (eventType){
                    case XmlPullParser.START_TAG:
                       // Log.e("parsexml","1231312");
                        if ("cm".equals(parser.getName())){
                            bean=new MedicineInfoBean();
                            id= Integer.parseInt(parser.getAttributeValue(null,"class"));

                           // Log.e("parsexml","cm");
                        }else  if ("name".equals(parser.getName())){
                            mName=parser.nextText();
                            bean.setmName(mName);
                            Log.e("parsexml","name");
                        }else  if ("cost".equals(parser.getName())){
                            cost=Integer.parseInt(parser.nextText());
                            bean.setCost(cost);
                          //  Log.e("parsexml","cost");
                        }else  if ("price".equals(parser.getName())){
                            price=Integer.parseInt(parser.nextText());
                            bean.setPrice(price);
                           // Log.e("parsexml","price");
                        }else  if ("profit".equals(parser.getName())){
                            profit=Integer.parseInt(parser.nextText());
                            bean.setProfit(profit);
                           // Log.e("parsexml","profit");
                        }else  if ("pic".equals(parser.getName())){
                            imageName=parser.nextText();
                            bean.setImageName(imageName);
                           // Log.e("parsexml",imageName);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                       // Log.e("parsexml","444444444");
                        list.add(bean);
                        bean=null;id=0;
                       /* mArray[id]=bean;
                        */
                        break;
                        default:break;

                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }
}
