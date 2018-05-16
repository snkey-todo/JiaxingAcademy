package com.huatec.greendao;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhusheng on 2018/5/12.
 */

public class MyApplication extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        //全局配置GreenDao
        GreenDaoManager.getInstance();
    }
}
