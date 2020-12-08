package com.alibaba.month1.mvp.view.activity;

import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.alibaba.lib_core.mvp.view.activity.BaseActivity;
import com.alibaba.month1.R;
import com.alibaba.month1.base.MyCommon;
import com.alibaba.month1.mvp.view.fragment.HomeFragment;
import com.alibaba.month1.mvp.view.fragment.MeFragment;
import com.alibaba.month1.mvp.view.fragment.MyListFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private FrameLayout fragment;
    private CommonTabLayout common;

    private HomeFragment homeFragment = new HomeFragment();
    private MyListFragment myListFragment = new MyListFragment();
    private MeFragment meFragment = new MeFragment();

    private ArrayList<CustomTabEntity> cuentity = new ArrayList<>();

    @Override
    public int getReslayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        fragment = findViewById(R.id.fragment);
        common = findViewById(R.id.common);

        cuentity.add(new MyCommon("首页", R.mipmap.home_true, R.mipmap.home_false));
        cuentity.add(new MyCommon("我的菜单", R.mipmap.shopping_true, R.mipmap.shopping_false));
        cuentity.add(new MyCommon("我的", R.mipmap.friend_true, R.mipmap.friend_false));

        common.setTabData(cuentity);

//        getWindow().setAttributes(R.color.colorpop);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, homeFragment)
                .add(R.id.fragment, myListFragment)
                .add(R.id.fragment, meFragment)
                .commit();

        changeFragment(homeFragment);

        common.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 0) {
                    changeFragment(homeFragment);
                } else if (position == 1) {
                    changeFragment(myListFragment);
                } else if (position == 2) {
                    changeFragment(meFragment);
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

    }

    @Override
    public void initData() {

    }

    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .hide(homeFragment)
                .hide(meFragment)
                .hide(myListFragment)
                .show(fragment)
                .commit();
    }
}