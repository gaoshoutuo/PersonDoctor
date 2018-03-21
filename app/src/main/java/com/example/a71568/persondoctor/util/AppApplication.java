package com.example.a71568.persondoctor.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by 71568 on 2017/12/10.
 */

public class AppApplication extends Application {
public static Context contextApp;

    @Override
    public void onCreate() {
        super.onCreate();
        contextApp=this;
    }

    public static AppApplication getContextApp(){
        return (AppApplication) contextApp;
    }
}
