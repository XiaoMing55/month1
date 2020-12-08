package com.alibaba.month1.base;

import com.flyco.tablayout.listener.CustomTabEntity;

public class MyCommon implements CustomTabEntity {

    private String title;
    private int imagel;
    private int unimage;

    public MyCommon(String title, int imagel, int unimage) {
        this.title = title;
        this.imagel = imagel;
        this.unimage = unimage;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return imagel;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unimage;
    }
}
