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
    @POST("GtSubcategoriesById")
    Call<GetSubcategoriesByIdRespond> getSubcategoriesByIdRespondCall(
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

    @FormUrlEncoded
    @POST("GetResultSearch")
    Call<ProductRespond> GetResultSearch(@Field("search") String search);

    @FormUrlEncoded
    @POST("GetProduct")
    Call<SingleProductResponse> GetProduct(@Field("id") int id);

    @FormUrlEncoded
    @POST("AddItemToCard")
    Call<AddItemToCardRespond> AddItemToCard(
            @Header("auth-token") String token,
            @Field("product_id") int id,
            @Field("quantity") int quantity,
            @Field("price") double price);

    @FormUrlEncoded
    @POST("Delete_item")
    Call<AddItemToCardRespond> Delete_item(
            @Header("auth-token") String token,
            @Field("cart_id") int id);

    @POST("GetCart")
    Call<GetCartRespond> GetCart(@Header("auth-token") String token);

    @POST("DeleteAccount")
    Call<DeleteAccountResponse> deleteAccount(@Header("auth-token") String token);

    @POST("Create_order")
    Call<AddItemToCardRespond> Create_order(@Header("auth-token") String token);

    @FormUrlEncoded
    @POST("update_account")
    Call<UpdateAccountResponse> updateAccount(
            @Header("auth-token") String token,
            @Field("username") String userName,
            @Field("password") String password,
            @Field("email") String email
    );
}

