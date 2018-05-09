package com.jiaxing.ict.day5_7_2;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpUtils {

    private static final String TAG = "OkhttpUtils";

    public static void get(String url){
        //1.创建请求客户端
        OkHttpClient client = new OkHttpClient();
        //2.创建一个请求对象
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        //3.创建一个请求并执行该请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.i(TAG,result);

                //toMember(result);
                toGoodsList(result);
            }
        });
    }

    /**
     *  解析数据-对象的集合
     * @param json
     */
    private static void toGoodsList(String json){
        try{
            JSONObject obj = new JSONObject(json);
            int status = obj.getInt("status");
            String msg = obj.getString("msg");
            String data = obj.getString("data");

            Log.i(TAG,"status:" + status);
            Log.i(TAG,"msg:" + msg);
            Log.i(TAG,"data:" + data);

            /**
             * List<String>
             * List<Goods>
             * List<Map<key,value>>
             */
            Gson gson = new Gson();
            List<Goods> goodsList = gson.fromJson(data,new TypeToken<List<Goods>>(){}.getType());
            Log.i(TAG,goodsList.toString());
            Log.i(TAG, goodsList.get(0).toString());
        }catch (Exception e){

        }

    }
    /**
     * 解析数据-对象
     @param json
     */
    private static void toMember(String json){
        try {
            JSONObject obj = new JSONObject(json);
            int status = obj.getInt("status");
            String msg = obj.getString("msg");
            String data = obj.getString("data");

            Log.i(TAG,"status:" + status);
            Log.i(TAG,"msg:" + msg);
            Log.i(TAG,"data:" + data);

            Gson gson = new Gson();
            Member member = gson.fromJson(data,Member.class);
            Log.i(TAG,member.toString());

            String str = member.getUname() + member.getEmail();
            Log.i(TAG,"取出成员变量"+str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
