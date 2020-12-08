package com.alibaba.month1.mvp.contract;

import com.alibaba.lib_core.mvp.model.IModel;
import com.alibaba.lib_core.mvp.view.view.IView;
import com.alibaba.month1.base.FoodBean;

import java.util.List;

import io.reactivex.Observer;

public interface FoodContract {
    interface View extends IView{
        int getStage_id();
        int getTitle();
        int getPage();
        void ok(List<FoodBean.DataBean> foodBeans);
        void no();
    }

    interface Model extends IModel{
        void getFoodEntity(int stage, int title, int page, Observer<FoodBean> observer);
    }
}
