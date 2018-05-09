package com.jiaxing.ict.day5_7;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpUtils {
    private static final String TAG ="OkhttpUtils" ;

    /**
     * 使用Okhttp
     * @param getUrl
     * @return
     */
    public static void get(String getUrl){
        //1.创建请求客户端
        OkHttpClient client = new OkHttpClient();
        //2.封装一个请求对象
        Request request = new Request.Builder()
                .get()
                .url(getUrl)
                .build();
        //3.执行请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result =   response.body().string();
                //Log.i(TAG,result);

                //toMember(result);
                toGoodsList(result);
            }
        });
     }

     private static void toGoodsList(String json){
         String newResult = "";
         try {
             JSONObject obj = new JSONObject(json);
             int status = obj.getInt("status");
             String msg = obj.getString("msg");
             newResult = obj.getString("data");
         } catch (JSONException e) {
             e.printStackTrace();
         }
         Gson gson = new Gson();
         List<Goods> goodsList = gson.fromJson(newResult, new TypeToken<List<Goods>>(){}.getType());
         Log.i(TAG,goodsList.toString());
     }
     private static void toMember(String json){
         String newResult = "";
         try {
             JSONObject obj = new JSONObject(json);
             int status = obj.getInt("status");
             String msg = obj.getString("msg");
             newResult = obj.getString("data");
         } catch (JSONException e) {
             e.printStackTrace();
         }
         Gson gson = new Gson();
         Member member =  gson.fromJson(newResult,Member.class);
         Log.i(TAG,member.toString());
     }
    /**
     *
     * @param postUrl
     * @param body
     */
     public static void post(String postUrl, FormBody body){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .post(body)
                .url(postUrl)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result =   response.body().string();
                Log.i(TAG,result);
            }
        });
     }
}
