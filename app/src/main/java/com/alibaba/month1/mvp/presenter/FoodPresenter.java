package com.alibaba.month1.mvp.presenter;

import com.alibaba.lib_core.mvp.presenter.BasePresenter;
import com.alibaba.month1.base.FoodBean;
import com.alibaba.month1.mvp.contract.FoodContract;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FoodPresenter extends BasePresenter<FoodContract.Model, FoodContract.View> {
    public FoodPresenter(FoodContract.Model mModel, FoodContract.View mView) {
        super(mModel, mView);
    }

    public void getView() {
        mModel.getFoodEntity(mView.getStage_id(), mView.getTitle(), mView.getPage(), new Observer<FoodBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(FoodBean foodBean) {
                mView.ok(foodBean.getData());
            }

            @Override
            public void onError(Throwable e) {
                mView.no();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
