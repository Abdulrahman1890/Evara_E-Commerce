package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");

        Call<SingleProductResponse> productDetails = ApiClient.getInstance().getApi().GetProduct(id);
        productDetails.enqueue(new Callback<SingleProductResponse>() {
            @Override
            public void onResponse(Call<SingleProductResponse> call, Response<SingleProductResponse> response) {
                SingleProductResponse singleProductResponse = response.body();
                SingleProduct[] product = singleProductResponse.getProduct();
                // set data of each product by product[0].method() to get the value
                Toast.makeText(getApplicationContext(), product[0].getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SingleProductResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}