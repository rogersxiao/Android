package com.example.rogersxiao.myapplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogersxiao on 2016/5/30.
 */
@Module
public class UserModule {
    public IViewInterface mIview;
    public UserModule(IViewInterface view){
        mIview = view;
    }
    @Provides
    public UserPersenter provideUserData(){
        return new UserPersenter(mIview);
    }
}
