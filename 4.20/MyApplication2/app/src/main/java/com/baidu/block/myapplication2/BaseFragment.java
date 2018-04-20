package com.baidu.block.myapplication2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class BaseFragment extends Fragment {

    public static final String TAG ="MyApplication";

    /**
     * 绑定到Activity
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.e(TAG,"onAttach");
    }

    /**
     * 创建阶段
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e(TAG,"onCreate");
    }

    /**
     * 初始化Fragment并返回布局为View对象
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_base,container,false);

        Log.e(TAG,"onCreateView");
        return view;
    }

    /**
     * Activity创建的时候调用
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG,"onActivityCreated");
    }

    /**
     * Fragment启动
     */
    @Override
    public void onStart() {
        super.onStart();

        Log.e(TAG,"onStart");
    }

    /**
     * Fragment展示的时候
     */
    @Override
    public void onResume() {
        super.onResume();

        Log.e(TAG,"onResume");
    }

    /**
     * Fragment暂停
     */
    @Override
    public void onPause() {
        super.onPause();

        Log.e(TAG,"onPause");
    }

    /**
     * Fragment停止
     */
    @Override
    public void onStop() {
        super.onStop();

        Log.e(TAG,"onStop");
    }

    /**
     * 销毁之前返回给Activity的View对象
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.e(TAG,"onDestroyView");
    }

    /**
     * 销毁Fragment
     */
    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e(TAG,"onDestroy");
    }

    /**
     * 将Fragment与Activity解绑
     */
    @Override
    public void onDetach() {
        super.onDetach();

        Log.e(TAG,"onDetach");
    }
}
