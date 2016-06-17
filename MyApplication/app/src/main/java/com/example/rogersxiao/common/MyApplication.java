package com.example.rogersxiao.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by rogersxiao on 2016/5/30.
 */
public class MyApplication extends Application {
    private AppComponent appComponent;


    public static MyApplication get(Context context){
        return (MyApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
/*        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .appServiceModule(new AppServiceModule())
                .build();*/
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }
}
