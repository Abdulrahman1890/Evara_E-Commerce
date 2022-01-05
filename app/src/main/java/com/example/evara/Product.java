package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
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
    ImageButton inc,dec;
    TextView title, price,quantity,shortdes,longdes;
    RatingBar rate;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        bundle = getIntent().getExtras();
        token = bundle.getString("token");
        int id = bundle.getInt("id");

        title =findViewById(R.id.title_product);
        price = findViewById(R.id.price_product);
        rate = findViewById(R.id.ratingBar);
        quantity = findViewById(R.id.prod_item_quantity);
        shortdes = findViewById(R.id.short_description_product);
        longdes = findViewById(R.id.long_description_product);
        inc = findViewById(R.id.prod_item_inc);
        dec = findViewById(R.id.prod_item_dec);


        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(quantity.getText().toString())+1;
                quantity.setText(num + "");
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(quantity.getText().toString())-1;
                if(num>1){
                    quantity.setText(num + "");
                }
            }
        });


        Call<SingleProductResponse> productDetails = ApiClient.getInstance().getApi().GetProduct(id);
        productDetails.enqueue(new Callback<SingleProductResponse>() {
            @Override
            public void onResponse(Call<SingleProductResponse> call, Response<SingleProductResponse> response) {
                SingleProductResponse singleProductResponse = response.body();
                product = singleProductResponse.getProduct();
                // set data of each product by product[0].method() to get the value
                ImageView img = findViewById(R.id.product_img);
                Glide.with(getApplicationContext())
                        .load("http://evara-shop.ahmed-projects.me"+ product[0].getPath())
                        .placeholder(R.drawable.cart)
                        .into(img);

                title.setText(product[0].getTitle());
                price.setText(product[0].getPrice());
                shortdes.setText(product[0].getShort_description());
                longdes.setText(product[0].getLong_description());

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
                Call<AddItemToCardRespond> addItemToCardRespondCall = ApiClient.getInstance().getApi().AddItemToCard(token,product[0].getId(),Integer.parseInt(quantity.getText().toString()),Integer.parseInt(quantity.getText().toString())*Double.parseDouble(product[0].getPrice()));
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