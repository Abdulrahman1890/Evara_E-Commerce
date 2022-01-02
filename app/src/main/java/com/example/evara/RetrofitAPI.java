package com.example.evara;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @FormUrlEncoded
    @POST("register_user")

    //on below line we are creating a method to post our data.
    Call<RegisterRespond> addUser(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("user_login")

        //on below line we are creating a method to post our data.
    Call<RegisterRespond> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );


    @POST("GetSubCategories")

        //on below line we are creating a method to post our data.
    Call<SubCategoryResponds> GetSubCategories();

    @POST("GetCategories")

        //on below line we are creating a method to post our data.
    Call<GetCategoryResponds> GetCategories();

    @POST("logout")

    //on below line we are creating a method to post our data.
    Call<LogOutRespond> logOut(
            @Header("auth-token") String token
    );

    @FormUrlEncoded
    @POST("GetProductByCategory")
    Call<ProductByCategoryRespond> GetProductByCategory(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("GetProductBySubCategory")
    Call<ProductByCategoryRespond> GetProductBySubCategory(
            @Field("id") int id
    );

    @POST("GetNewestProduct")
    Call<ProductRespond> GetNewestProduct();

    @POST("GetOldestProduct")
    Call<ProductRespond> GetOldestProduct();

    @POST("GetHighestPrices")
    Call<ProductRespond> GetHighestPrices();

    @POST("GetLowestPrices")
    Call<ProductRespond> GetLowestPrices();

    @POST("GetPopularProducts")
    Call<ProductRespond> GetPopularProducts();

    @POST("GetPopularProducts")
    Call<ProductRespond> GetResultSearch();

    @FormUrlEncoded
    @POST("GetProduct")
    Call<SingleProductResponse> GetProduct(@Field("id") int id);
}

