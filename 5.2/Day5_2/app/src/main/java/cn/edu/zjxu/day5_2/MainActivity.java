package cn.edu.zjxu.day5_2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private static final String TAG = "MainActivity";
    //http://10.37.59.239:8080/MobileShop/swagger/index.html#/
    private String getUrl = "http://10.37.59.239:8080/MobileShop/member/35";
    private String postURl="http://10.37.59.239:8080/MobileShop/member/login";
    private String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525263780853&di=a474b44c1266cb1cc5ef287d1586466d&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd50735fae6cd7b89acbea9df032442a7d8330e9f.jpg";

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what ==1){
                Bitmap bmp = (Bitmap) msg.obj;
                imageView.setImageBitmap(bmp);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);
        imageView = findViewById(R.id.iv);
      /*  new Thread(new Runnable() {
            @Override
            public void run() {

                //String result = get("http://10.37.59.239:8080/MobileShop/cat/show");
                //String result = getPage("https://www.baidu.com/");
                Map<String,String> params = new HashMap<>();
                params.put("uname","zhusheng");
                params.put("password","zhusheng");
                String result = post("http://10.37.59.239:8080/MobileShop/member/login",params);
                Log.e(TAG,result);
            }
        }).start();*/

        //getPage("https://www.baidu.com/");
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String result = getPage("https://www.baidu.com/");
                Log.e(TAG,result);
            }
        };*/
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                //String result = getPage("https://www.baidu.com/");
                String result = get(getUrl);
                Log.e(TAG,result);
            }
        }).start();*/

        /**
         * 使用okhttp进行get请求
         */
        /*//1.创建网络请求对象
        OkHttpClient client = new OkHttpClient();
        //2.创建一个请求对象
        Request request = new Request.Builder().get().url(getUrl).build();
        //3.创建一个Call对象，负责发起请求并接收数据
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG,response.body().string());
            }

        });*/

        /**
         * 使用okhttp进行post请求
         */
        /*//1.创建一个请求客户端
        OkHttpClient client = new OkHttpClient();
        //2.1 封装请求的表单数据对象
        RequestBody body = new FormBody.Builder()
                .add("uname","zhusheng")
                .add("password","zhusheng")
                .build();
        //2.2 创建一个请求对象
        Request request = new Request.Builder()
                .post(body)
                .url(postURl)
                .build();
        //3.创建Call并发起请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.i(TAG,str);
                textView.setText(str);
            }
        });*/

        /**
         * 使用okhttp框架加载图片
         */
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(imageUrl)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] result = response.body().bytes();
                Bitmap bmp = BitmapFactory.decodeByteArray(result,0,result.length);
                //imageView.setImageBitmap(bmp);
                Message msg = handler.obtainMessage(1,bmp);
                handler.sendMessage(msg);
            }
        });

    }

    //加载一个网页
    public String getPage(String urlString){
        HttpURLConnection urlConnection = null;
        BufferedReader rd = null ;
        StringBuilder sb = new StringBuilder ();
        String line = null ;
        String response = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            rd  = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null ) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return response;
    }
    //get请求
    public String get(String url){
        HttpURLConnection conn = null;
        BufferedReader rd = null ;
        StringBuilder sb = new StringBuilder ();
        String line = null ;
        String response = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);
            conn.setUseCaches(false);
            conn.connect();
            rd  = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null ) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rd != null){
                    rd.close();
                }
                if(conn != null){
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
    //post表单请求
    public String post(String url, Map<String, String> form){
        HttpURLConnection conn = null;
        PrintWriter pw = null ;
        BufferedReader rd = null ;
        StringBuilder out = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        String line = null ;
        String response = null;
        for (String key : form.keySet()) {
            if(out.length()!=0){
                out.append("&");
            }
            out.append(key).append("=").append(form.get(key));
        }

        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);
            conn.setUseCaches(false);
            conn.connect();
            pw = new PrintWriter(conn.getOutputStream());
            pw.print(out.toString());
            pw.flush();
            rd  = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null ) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(pw != null){
                    pw.close();
                }
                if(rd != null){
                    rd.close();
                }
                if(conn != null){
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
    //post字符串请求
    public String post(String url, String rawBody){
        HttpURLConnection conn = null;
        PrintWriter pw = null ;
        BufferedReader rd = null ;
        StringBuilder sb = new StringBuilder ();
        String line = null ;
        String response = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);
            conn.setUseCaches(false);
            conn.connect();
            pw = new PrintWriter(conn.getOutputStream());
            pw.print(rawBody);
            pw.flush();
            rd  = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null ) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(pw != null){
                    pw.close();
                }
                if(rd != null){
                    rd.close();
                }
                if(conn != null){
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }


}
