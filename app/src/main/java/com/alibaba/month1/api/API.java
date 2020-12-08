package com.alibaba.month1.api;

import com.alibaba.month1.base.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("ios/cf/dish_list.php")
    Observable<FoodBean> getFoodBean(
            @Query("stage_id") int stageid,
            @Query("limit") int limit,
            @Query("page") int page);
}
