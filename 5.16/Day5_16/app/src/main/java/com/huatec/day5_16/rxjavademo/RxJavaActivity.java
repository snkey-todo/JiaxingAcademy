package com.huatec.day5_16.rxjavademo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.huatec.day5_16.R;
import com.huatec.day5_16.model.Course;
import com.huatec.day5_16.model.Student;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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

    private void doFlatMap() {
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
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getCourses());
                    }
                }).subscribe(subscriber);
    }

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

    private void doRxJava() {
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

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello1");
                subscriber.onNext("hello2");
                subscriber.onNext("hello3");
                subscriber.onCompleted();
//                subscriber.onError(new RuntimeException("出现错误啦"));
            }
        });
        // just方式
//        Observable observable1 = Observable.just("hello1","hello2","hello3");

        // from方式
//        String[] words = {"hello1","hello2","hello3"};
//        Observable observable1 = Observable.from(words);

        observable.subscribe(observer);

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
