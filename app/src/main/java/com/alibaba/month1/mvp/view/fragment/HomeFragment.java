package com.alibaba.month1.mvp.view.fragment;

import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.lib_core.mvp.view.fragment.BaseFragment;
import com.alibaba.month1.R;
import com.alibaba.month1.base.MyViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {
    private EditText etSeek;
    private TabLayout tabMode;
    private ViewPager vp;
    private MyFragment myFragment = new MyFragment();
    private MyListFragment myListFragment = new MyListFragment();
    private MeFragment meFragment = new MeFragment();
    private List<String> tabtitle = new ArrayList<>();

    private List<Fragment> fragments = new ArrayList<>();

    private MyViewPagerAdapter myViewPagerAdapter;

    @Override
    public int getReslayout() {
        return R.layout.home_fragment;
    }

    @Override
    public void initView() {
        etSeek = (EditText) findViewById(R.id.et_seek);
        tabMode = (TabLayout) findViewById(R.id.tabMode);
        vp = (ViewPager) findViewById(R.id.vp);

        tabtitle.add("热门商品");
        tabtitle.add("推荐");
        tabtitle.add("其他");

        fragments.add(myFragment);
        fragments.add(myListFragment);
        fragments.add(meFragment);

        myViewPagerAdapter = new MyViewPagerAdapter(getFragmentManager(), fragments, tabtitle);

        vp.setAdapter(myViewPagerAdapter);

        tabMode.setupWithViewPager(vp);

    }

    @Override
    public void initData() {

    }
}
