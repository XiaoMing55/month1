package com.alibaba.month1.mvp.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.lib_core.mvp.view.fragment.BaseFragment;
import com.alibaba.month1.R;
import com.alibaba.month1.adapter.MyAdapter;
import com.alibaba.month1.base.FoodBean;
import com.alibaba.month1.mvp.contract.FoodContract;
import com.alibaba.month1.mvp.model.FoodModel;
import com.alibaba.month1.mvp.presenter.FoodPresenter;
import com.alibaba.month1.mvp.view.activity.MainActivity2;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

public class MyFragment extends BaseFragment implements FoodContract.View {
    private RecyclerView cy;
    private MyAdapter myAdapter;
    private FoodPresenter foodPresenter;
    @Override
    public int getReslayout() {
        return R.layout.my_fragment;
    }

    @Override
    public void initView() {

        cy = (RecyclerView) findViewById(R.id.cy);

        cy.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        cy.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));

    }

    @Override
    public void initData() {
        foodPresenter = new FoodPresenter(new FoodModel(),this);
        foodPresenter.getView();
    }

    @Override
    public int getStage_id() {
        return 1;
    }

    @Override
    public int getTitle() {
        return 20;
    }

    @Override
    public int getPage() {
        return 1;
    }

    @Override
    public void ok(final List<FoodBean.DataBean> foodBeans) {
        myAdapter = new MyAdapter(foodBeans);
        cy.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //跳转详情页面
                Intent intent = new Intent(getContext(), MainActivity2.class);
                intent.putExtra("pic",foodBeans.get(position).getPic());
                startActivity(intent);
            }
        });
    }

    @Override
    public void no() {
        Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
    }
}
