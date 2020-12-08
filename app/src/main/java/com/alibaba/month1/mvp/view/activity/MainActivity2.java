package com.alibaba.month1.mvp.view.activity;

import android.widget.ImageView;

import com.alibaba.lib_core.mvp.view.activity.BaseActivity;
import com.alibaba.month1.R;
import com.bumptech.glide.Glide;

public class MainActivity2 extends BaseActivity {
    private ImageView main2Image;

    @Override
    public int getReslayout() {
        return R.layout.activity_main2;
    }

    @Override
    public void initView() {

        String pic = getIntent().getStringExtra("pic");

        main2Image = findViewById(R.id.main2_image);

        Glide.with(this).load(pic).into(main2Image);
    }

    @Override
    public void initData() {

    }
}