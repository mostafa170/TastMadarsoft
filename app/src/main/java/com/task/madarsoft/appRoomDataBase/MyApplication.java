package com.task.madarsoft.appRoomDataBase;


import android.app.Application;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        AppDataBase.init(this);
    }
}
