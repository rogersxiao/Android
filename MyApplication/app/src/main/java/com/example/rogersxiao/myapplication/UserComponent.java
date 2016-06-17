package com.example.rogersxiao.myapplication;

import dagger.Component;

/**
 * Created by rogersxiao on 2016/5/30.
 */

@Component(modules = UserModule.class)
public interface UserComponent {
    LoginActivity inject(LoginActivity activity);
}
