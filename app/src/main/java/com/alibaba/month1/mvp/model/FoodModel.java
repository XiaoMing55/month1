package com.alibaba.month1.mvp.model;

import com.alibaba.lib_core.http.HttpRetrofitManager;
import com.alibaba.month1.api.API;
import com.alibaba.month1.base.FoodBean;
import com.alibaba.month1.mvp.contract.FoodContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FoodModel implements FoodContract.Model {

    @Override
    public void getFoodEntity(int stage, int title, int page, Observer<FoodBean> observer) {
        HttpRetrofitManager.getManager().getRetrofit("http://www.qubaobei.com/")
                .create(API.class)
                .getFoodBean(stage, title, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    @Override
    public void destory() {

    }
}
