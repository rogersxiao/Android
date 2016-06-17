package com.example.rogersxiao.myapplication

import android.util.Log
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by rogersxiao on 2016/5/30.
 */
class UserPersenter(view : IViewInterface) {
    val TAG = "UserPersenter"
    val mView = view
    var baseUrl = "http://115.159.198.205:3000"
    var retrofit =  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    fun getUserInfo(name:String){
        var userApi = retrofit.create(UserApi::class.java)
        userApi.getUserInfo(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ u ->  mView.showUserData(u)},{e -> Log.d(TAG,e.toString())})
    }
}
