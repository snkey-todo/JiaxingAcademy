package com.jiaxing.ict.day5_7_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String getUrl = "http://10.37.59.239:8080/MobileShop/member/35";
    private String getUrl2 = "http://10.37.59.239:8080/MobileShop/cat/show";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //调用get请求方法
        OkhttpUtils.get(getUrl2);
    }
}
