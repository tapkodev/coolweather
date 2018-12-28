package com.guixin.tapko.application;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

import interfaces.heweather.com.interfacesmodule.view.HeConfig;

/**
 * Created by lenovo on 2018/12/27.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        context = getApplicationContext();
        LitePal.initialize(context);
        HeConfig.init("HE1812242058401815","65f1982e5de946d590e76fa80f3a5b7e");
        HeConfig.switchToFreeServerNode();
    }
    public static Context getContext(){
        return context;
    }
}
