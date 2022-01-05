package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatoGridView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HorizontalHomeAdapter adapter;
    private ArrayList<ItemModel> arrayList;
    private RecyclerView.LayoutManager layoutManager;
    private Bundle bundle;
    private String title , token;
    private TextView textView_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        bundle = getIntent().getExtras();
        recyclerView = findViewById(R.id.grid_view);
        layoutManager = new GridLayoutManager(getApplicationContext() , 3);
        recyclerView.setLayoutManager(layoutManager);
        title = bundle.getString("title");
        token = bundle.getString("token");

        textView_title = findViewById(R.id.grid_view_title);
        textView_title.setText(title);

        if(title.equals("Newest Product "))
            newProduct();
        if(title.equals("Oldest Product "))
            oldProduct();
        if(title.equals("Highest Product "))
            highProduct();
        if(title.equals("Lowest Product "))
            lowProduct();
        if(title.equals("Most Popular Product "))
            mostProduct();




    }
    public void newProduct(){
        Call<ProductRespond> newProductApi = ApiClient.getInstance().getApi().GetNewestProduct();

        newProductApi.enqueue(new Callback<ProductRespond>() {
            @Override
            public void onResponse(Call<ProductRespond> call, Response<ProductRespond> response) {
                ProductRespond productRespond = response.body();
                SingleProduct[] products = productRespond.getProducts();
                ArrayList<ItemModel> itemModelArrayList= new ArrayList<ItemModel>();
                for (int i = 0;i < products.length; i++){
                    ItemModel itemModel = new ItemModel(products[i].getPath(),products[i].getTitle() ,Double.parseDouble(products[i].getPrice()),products[i].getId(),token);
                    itemModelArrayList.add(itemModel);
                }

                adapter = new HorizontalHomeAdapter(getApplicationContext(),itemModelArrayList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductRespond> call, Throwable t) {

            }
        });

    }
    public void oldProduct(){
        Call<ProductRespond> oldProductApi = ApiClient.getInstance().getApi().GetOldestProduct();

        oldProductApi.enqueue(new Callback<ProductRespond>() {
            @Override
            public void onResponse(Call<ProductRespond> call, Response<ProductRespond> response) {
                ProductRespond productRespond = response.body();
                SingleProduct[] products = productRespond.getProducts();
                ArrayList<ItemModel> itemModelArrayList =new ArrayList<>();
                for (int i = 0;i < products.length;i++){
                    ItemModel itemModel = new ItemModel(products[i].getPath(),products[i].getTitle() ,Double.parseDouble(products[i].getPrice()),products[i].getId(),token);
                    itemModelArrayList.add(itemModel);
                }
                adapter = new HorizontalHomeAdapter(getApplicationContext(),itemModelArrayList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductRespond> call, Throwable t) {

            }
        });

    }
    public void highProduct(){
        Call<ProductRespond> highProductApi = ApiClient.getInstance().getApi().GetHighestPrices();

        highProductApi.enqueue(new Callback<ProductRespond>() {
            @Override
            public void onResponse(Call<ProductRespond> call, Response<ProductRespond> response) {
                ProductRespond productRespond = response.body();
                SingleProduct[] products = productRespond.getProducts();
                ArrayList<ItemModel> itemModelArrayList =new ArrayList<>();
                for (int i = 0;i < products.length;i++){
                    ItemModel itemModel = new ItemModel(products[i].getPath(),products[i].getTitle() ,Double.parseDouble(products[i].getPrice()),products[i].getId(),token);
                    itemModelArrayList.add(itemModel);
                }
                adapter = new HorizontalHomeAdapter(getApplicationContext(),itemModelArrayList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductRespond> call, Throwable t) {

            }
        });

    }
    public void lowProduct(){
        Call<ProductRespond> lowProductApi = ApiClient.getInstance().getApi().GetLowestPrices();

        lowProductApi.enqueue(new Callback<ProductRespond>() {
            @Override
            public void onResponse(Call<ProductRespond> call, Response<ProductRespond> response) {
                ProductRespond productRespond = response.body();
                SingleProduct[] products = productRespond.getProducts();
                ArrayList<ItemModel> itemModelArrayList =new ArrayList<>();
                for (int i = 0;i < products.length;i++){
                    ItemModel itemModel = new ItemModel(products[i].getPath(),products[i].getTitle(),Double.parseDouble(products[i].getPrice()),products[i].getId(),token);
                    itemModelArrayList.add(itemModel);
                }
                adapter = new HorizontalHomeAdapter(getApplicationContext(),itemModelArrayList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductRespond> call, Throwable t) {

            }
        });

    }
    public void mostProduct(){
        Call<ProductRespond> mostProductApi = ApiClient.getInstance().getApi().GetPopularProducts();

        mostProductApi.enqueue(new Callback<ProductRespond>() {
            @Override
            public void onResponse(Call<ProductRespond> call, Response<ProductRespond> response) {
                ProductRespond productRespond = response.body();
                SingleProduct[] products = productRespond.getProducts();
                ArrayList<ItemModel> itemModelArrayList =new ArrayList<>();
                for (int i = 0;i < products.length;i++){
                    ItemModel itemModel = new ItemModel(products[i].getPath(),products[i].getTitle(),Double.parseDouble(products[i].getPrice()),products[i].getId(),token);
                    itemModelArrayList.add(itemModel);
                }
                adapter = new HorizontalHomeAdapter(getApplicationContext(),itemModelArrayList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductRespond> call, Throwable t) {

            }
        });

    }
}