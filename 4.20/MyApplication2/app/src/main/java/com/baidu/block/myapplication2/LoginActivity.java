package com.baidu.block.myapplication2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "MyApplication";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Log.i(TAG,"onCreate");
        BaseFragment baseFragment = new BaseFragment();

        //Fragment管理类
        FragmentManager manager = getFragmentManager();

        //事务
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.fragment_content,baseFragment);

        //一定要记得提交
        transaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG,"onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG,"onRestart");
    }
}

