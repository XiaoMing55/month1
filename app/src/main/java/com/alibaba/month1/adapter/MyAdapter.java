package com.alibaba.month1.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.month1.R;
import com.alibaba.month1.base.FoodBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MyAdapter extends BaseQuickAdapter<FoodBean.DataBean,BaseViewHolder> {

    public MyAdapter(@Nullable List<FoodBean.DataBean> data) {
        super(R.layout.myadapter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodBean.DataBean item) {
        Glide.with(mContext).load(item.getPic()).into((ImageView) helper.getView(R.id.iv_image));

        helper.setText(R.id.tv_title,item.getTitle());

    }
}
