package com.example.evara;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @FormUrlEncoded
    @POST("register_user")

    //on below line we are creating a method to post our data.
    Call<RegisterRespond> addUser(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password);
}

