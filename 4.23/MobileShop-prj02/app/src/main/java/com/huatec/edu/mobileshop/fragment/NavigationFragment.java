package com.huatec.edu.mobileshop.fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.huatec.edu.mobileshop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends BaseFragment implements View.OnClickListener{

    private LinearLayout tabItemHome;
    private LinearLayout tabItemCategory;
    private LinearLayout tabItemCart;
    private LinearLayout tabItemPersonal;

    private ImageButton tabItemHomeBtn;
    private ImageButton tabItemCategoryBtn;
    private ImageButton tabItemCartBtn;
    private ImageButton tabItemPersonalBtn;


    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    public CartFragment cartFragment;
    private PersonFragment personFragment;

    private FragmentManager fragmentManager;

    public int currentId;

    public NavigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        initViews(view);
        setTabSelection(R.id.tab_item_home);
        return view;
    }

    //初始化视图对象
    private void initViews(View view) {
        tabItemHome = (LinearLayout) view.findViewById(R.id.tab_item_home);
        tabItemHome.setOnClickListener(this);
        tabItemCategory = (LinearLayout) view.findViewById(R.id.tab_item_category);
        tabItemCategory.setOnClickListener(this);
        tabItemCart = (LinearLayout) view.findViewById(R.id.tab_item_cart);
        tabItemCart.setOnClickListener(this);
        tabItemPersonal = (LinearLayout) view.findViewById(R.id.tab_item_personal);
        tabItemPersonal.setOnClickListener(this);

        tabItemHomeBtn = (ImageButton) view.findViewById(R.id.tab_item_home_btn);
        tabItemCategoryBtn = (ImageButton) view.findViewById(R.id.tab_item_category_btn);
        tabItemCartBtn = (ImageButton) view.findViewById(R.id.tab_item_cart_btn);
        tabItemPersonalBtn = (ImageButton) view.findViewById(R.id.tab_item_personal_btn);


        fragmentManager = getFragmentManager();
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        setTabSelection(v.getId());
    }

    /**
     * 设置Tab选中
     * @param id
     */
    public void setTabSelection(int id){
        //重置所有tabItem状态
        tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_focus);
        tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_focus);
        tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_focus);
        tabItemPersonalBtn.setImageResource(R.drawable.tab_item_personal_focus);


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //隐藏所有Fragment
        if(homeFragment != null)
            fragmentTransaction.hide(homeFragment);
        if(categoryFragment != null)
            fragmentTransaction.hide(categoryFragment);
        if(cartFragment != null)
            fragmentTransaction.hide(cartFragment);
        if(personFragment != null)
            fragmentTransaction.hide(personFragment);

        //根据tabItem的id来执行不同的操作
        switch(id){
            case R.id.tab_item_home:
                tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_normal);
                if(homeFragment == null){
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content, homeFragment);
                }else{
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.tab_item_category:
                tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_normal);
                if(categoryFragment == null){
                    categoryFragment = new CategoryFragment();
                    fragmentTransaction.add(R.id.content, categoryFragment);
                }else{
                    fragmentTransaction.show(categoryFragment);
                }
                break;
            case R.id.tab_item_cart:
                tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_normal);
                if(cartFragment == null){
                    cartFragment = new CartFragment();
                    fragmentTransaction.add(R.id.content, cartFragment);
                }else{
                    fragmentTransaction.show(cartFragment);
                }
                break;
            case R.id.tab_item_personal:
                tabItemPersonalBtn.setImageResource(R.drawable.tab_item_personal_normal);
                if(personFragment == null){
                    personFragment = new PersonFragment();
                    fragmentTransaction.add(R.id.content, personFragment);
                }else{
                    fragmentTransaction.show(personFragment);
                }
                break;
        }
        fragmentTransaction.commit();
        currentId = id;
    }


}
