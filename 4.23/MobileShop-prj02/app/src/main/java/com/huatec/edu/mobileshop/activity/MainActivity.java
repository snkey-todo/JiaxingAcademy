package com.huatec.edu.mobileshop.activity;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.fragment.NavigationFragment;

public class MainActivity extends AppCompatActivity {
    private NavigationFragment navigationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //添加主容器
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        navigationFragment = new NavigationFragment();
        transaction.add(R.id.main_frame,navigationFragment);
        transaction.commit();
    }
}
