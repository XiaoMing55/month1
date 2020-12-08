package com.alibaba.my_lib_core.http;


import com.alibaba.lib_core.http.HttpRetrofitManager;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyHttp   {
    private static MyHttp manager = new MyHttp();

    public static MyHttp getManager() {
        return manager;
    }

    private MyHttp() {
    }

    private Retrofit retrofit;
    private String urlPath = "";

    public Retrofit getRetrofit(String url) {
        if (retrofit == null) {
            create(url);
            urlPath = url;
        }else {
            if (!urlPath.equals(url)){
                create(url);
            }
        }
        return retrofit;
    }

    private void create(String url) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okbuilder = new OkHttpClient.Builder();
        okbuilder.addInterceptor(interceptor)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(url)
                .client(okbuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
