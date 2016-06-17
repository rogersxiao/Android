package com.example.rogersxiao.myapplication;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rogersxiao on 2016/5/30.
 */
public interface UserApi {
    @GET("/users/show")
    Observable<UserData> getUserInfo(@Query("name") String name);

}
