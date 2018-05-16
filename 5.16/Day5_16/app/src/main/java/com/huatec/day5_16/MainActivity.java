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
    private String tag = getClass().getSimpleName();

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

    private void getGoodsDetail() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.37.59.239:8080/MobileShop/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GoodsService service = retrofit.create(GoodsService.class);

        Call<HttpResult<GoodsEntity>> call = service.getGoodsDetail(89);
        call.enqueue(new Callback<HttpResult<GoodsEntity>>() {
            @Override
            public void onResponse(Call<HttpResult<GoodsEntity>> call, Response<HttpResult<GoodsEntity>> response) {
                Log.d(tag,response.body().getData().toString());
                tvResult.setText(response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<HttpResult<GoodsEntity>> call, Throwable t) {

            }
        });
    }


}
