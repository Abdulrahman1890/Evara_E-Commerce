package com.example.evara;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://evara-shop.ahmed-projects.me/api/";
    public static ApiClient mInstance;
    private Retrofit retrofit;

    private ApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized ApiClient getInstance(){
        if(mInstance == null)
        {
            mInstance = new ApiClient();
        }
        return mInstance;
    }
    public RetrofitAPI getApi(){
        return retrofit.create(RetrofitAPI.class);
    }
}
