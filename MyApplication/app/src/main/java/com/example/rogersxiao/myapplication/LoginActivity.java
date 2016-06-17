package com.example.rogersxiao.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rogersxiao.R;

import javax.inject.Inject;

/**
 * Created by rogersxiao on 2016/6/15.
 */
public class LoginActivity extends Activity implements IViewInterface{
    private Button mLogin;
    private EditText mUserName;
    private TextView mUserAge;
    private TextView mUserSex;
    @Inject
    public UserPersenter userPersenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupActivityComponent();
        mLogin = (Button) findViewById(R.id.query_user_info);
        mUserName = (EditText) findViewById(R.id.editText);
        mUserSex = (TextView) findViewById(R.id.user_sex);
        mUserAge = (TextView) findViewById(R.id.user_age);
        mLogin.setOnClickListener( v -> userPersenter.getUserInfo(mUserName.getText().toString()));
    }

    @Override
    public void showUserData(UserData data) {
        mUserAge.setText(data.mAge);
        mUserSex.setText(data.mSex);
    }

    public void setupActivityComponent(){
         DaggerUserComponent.builder().userModule(new UserModule(this)).build().inject(this);
    }
}
