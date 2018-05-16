package com.huatec.day5_16.rxjavademo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.huatec.day5_16.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxJavaActivity extends AppCompatActivity {

    private String tag = getClass().getSimpleName();

    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        mIv = findViewById(R.id.mIv);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                doRxJava();
                break;
            case R.id.btn2:
                doMap();
                break;
            case R.id.btn3:
                doFlatMap();
                break;
        }
    }

    /**
     * 处理一对多
     */
    private void doFlatMap() {
        //模拟数据
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Student student = new Student();
            student.setName("张三" + i);
            List<Course> courses = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                Course course = new Course("语文" + (i+j));
                courses.add(course);
            }
            student.setCourses(courses);
            students.add(student);
        }

        Subscriber<Course> subscriber = new Subscriber<Course>() {
            @Override
            public void onCompleted() {
                Log.d(tag, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag, "onError");

            }

            @Override
            public void onNext(Course course) {
                Log.d(tag, course.getName());
            }
        };
        /**
         * 订阅
         */
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        Log.d(tag,student.getName());
                        return Observable.from(student.getCourses());
                    }
                }).subscribe(subscriber);
    }

    /**
     * 处理一对一
     */
    private void doMap() {
        Observable.just("/res/drawable/hello.png")
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        return getBitmapFromPath(s);
                    }
                }).subscribe(new Action1<Bitmap>() {
            @Override
            public void call(Bitmap bitmap) {
                showBitmap(bitmap);
            }
        });
    }

    /**
     * 创建观察者、被观察者、订阅的方式
     */
    private void doRxJava() {
        /**
         * 方式1：创建观察者
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(tag, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag, "onError");

            }

            @Override
            public void onNext(String s) {
                Log.d(tag, "item:" + s);

            }
        };
        /**
         * 方式2：创建观察者
         */
//        Subscriber<String> subscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.d(tag, "onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(tag, "onError");
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d(tag, "item:" + s);
//            }
//        };
        /**
         * 方式1：创建被观察者
         */
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello1");
                subscriber.onNext("hello2");
                subscriber.onNext("hello3");
                subscriber.onCompleted();   //成功
//                subscriber.onError(new RuntimeException("出现错误啦"));//失败
            }
        });
        /**
         * 方式2：使用just创建被观察者
         */
        // just方式
//        Observable observable1 = Observable.just("hello1","hello2","hello3");

        /**
         * 方式3：使用from创建被观察者
         */
        // from方式
//        String[] words = {"hello1","hello2","hello3"};
//        Observable observable1 = Observable.from(words);


        /**
         * 订阅方式1
         */
        observable.subscribe(observer);
        /**
         * 订阅方式2
         */
        // 线程控制的示例代码
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);


    }

    private void showBitmap(Bitmap bitmap) {
        mIv.setImageBitmap(bitmap);
    }

    private Bitmap getBitmapFromPath(String path) {
        Bitmap bitmap = BitmapFactory.decodeStream(getClass().getResourceAsStream(path));
        return bitmap;
    }
}
