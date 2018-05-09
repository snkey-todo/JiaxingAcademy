package com.jiaxing.ict.day5_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import okhttp3.FormBody;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    String getUrl = "http://10.37.59.239:8080/MobileShop/member/35";
    String postUrl = "http://10.37.59.239:8080/MobileShop/member/login";
    String getUrl2 = "http://10.37.59.239:8080/MobileShop/cat/show";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkhttpUtils.get(getUrl2);
       /* FormBody formBody = new FormBody.Builder()
                .add("uname","zhusheng")
                .add("password","zhusheng")
                .build();
        OkhttpUtils.post(postUrl,formBody);*/

    }
}
