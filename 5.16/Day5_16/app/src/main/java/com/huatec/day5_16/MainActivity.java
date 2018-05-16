package com.huatec.day5_16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.huatec.day5_16.model.GoodsEntity;
import com.huatec.day5_16.model.HttpResult;
import com.huatec.day5_16.rxjavademo.RxJavaActivity;
import com.huatec.day5_16.service.GoodsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.mTvResult);
    }


    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                getGoodsDetail();
                break;
            case R.id.btnRx:
                goRxJava();
                break;
            case R.id.btn2:
                getGoods();
                break;
        }
    }

    /**
     * Retrofit post请求
     */
    private void getGoods() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.37.59.239:8080/MobileShop/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GoodsService service = retrofit.create(GoodsService.class);

        Call<HttpResult<List<GoodsEntity>>> call = service.getGoods("1");
        call.enqueue(new Callback<HttpResult<List<GoodsEntity>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<GoodsEntity>>> call, Response<HttpResult<List<GoodsEntity>>> response) {
                HttpResult<List<GoodsEntity>> httpResult =  response.body();

                List<GoodsEntity> list = httpResult.getData();


                Log.d(tag,response.body().getData().toString());
                tvResult.setText(response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<HttpResult<List<GoodsEntity>>> call, Throwable t) {

            }
        });
    }

    private void goRxJava() {
        startActivity(new Intent(this, RxJavaActivity.class));
    }

    /**
     * Retrofit get请求
     */
    private void getGoodsDetail() {
        /**
         * 第一步：创建Retrofit对象
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.37.59.239:8080/MobileShop/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /**
         *第二步：获取Service对象
         */
        GoodsService service = retrofit.create(GoodsService.class);
        /**
         *第三步：执行网络请求
         */
        Call<HttpResult<GoodsEntity>> call = service.getGoodsDetail(89);
        call.enqueue(new Callback<HttpResult<GoodsEntity>>() {
            @Override
            public void onResponse(Call<HttpResult<GoodsEntity>> call, Response<HttpResult<GoodsEntity>> response) {

                HttpResult<GoodsEntity> httpResult = response.body();

                int status = httpResult.getStatus();
                String msg = httpResult.getMsg();
                GoodsEntity goodsEntity = httpResult.getData();

                Log.d(tag,"status:" + status);
                Log.d(tag,"msg:" + msg);
                Log.d(tag,goodsEntity.toString());

                tvResult.setText(response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<HttpResult<GoodsEntity>> call, Throwable t) {

            }
        });

    }


}
