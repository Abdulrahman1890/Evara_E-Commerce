package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Product extends AppCompatActivity {
    Button addToCart;
    Bundle bundle;
    String token;
    SingleProduct[] product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        bundle = getIntent().getExtras();
        String token = bundle.getString("token");
        int id = bundle.getInt("id");

        Call<SingleProductResponse> productDetails = ApiClient.getInstance().getApi().GetProduct(id);
        productDetails.enqueue(new Callback<SingleProductResponse>() {
            @Override
            public void onResponse(Call<SingleProductResponse> call, Response<SingleProductResponse> response) {
                SingleProductResponse singleProductResponse = response.body();
                product = singleProductResponse.getProduct();
                // set data of each product by product[0].method() to get the value
                Toast.makeText(getApplicationContext(), product[0].getTitle(), Toast.LENGTH_SHORT).show();
                ImageView img = findViewById(R.id.product_img);
                Glide.with(getApplicationContext())
                        .load( "http://evara-shop.ahmed-projects.me"+ product[0].getPath())
                        .placeholder(R.drawable.cart)
                        .into(img);
            }

            @Override
            public void onFailure(Call<SingleProductResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        addToCart = findViewById(R.id.btn_add_to_cart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<AddItemToCardRespond> addItemToCardRespondCall = ApiClient.getInstance().getApi().AddItemToCard(token,product[0].getId(),1,Integer.parseInt(product[0].getPrice()));
                addItemToCardRespondCall.enqueue(new Callback<AddItemToCardRespond>() {
                    @Override
                    public void onResponse(Call<AddItemToCardRespond> call, Response<AddItemToCardRespond> response) {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<AddItemToCardRespond> call, Throwable t) {

                    }
                });
            }
        });
    }
}