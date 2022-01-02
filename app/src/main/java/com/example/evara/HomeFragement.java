package com.example.evara;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragement extends Fragment {
    private RecyclerView verticalRecyclerView;
    private HomeVerticalAdapter adapter;
    private ArrayList<CategoryModel> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.home_fragement,container,false);
        verticalRecyclerView = view.findViewById(R.id.home_recycle_view);
        verticalRecyclerView.setHasFixedSize(true);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        arrayList = new ArrayList<>();

        adapter = new HomeVerticalAdapter(getContext(),arrayList);
        verticalRecyclerView.setAdapter(adapter);

        mostProduct();
        newProduct();
        oldProduct();
        highProduct();
        lowProduct();

        return view;
    }

    public void newProduct(){
        Call<ProductRespond> newProductApi = ApiClient.getInstance().getApi().GetNewestProduct();

        newProductApi.enqueue(new Callback<ProductRespond>() {
            @Override
            public void onResponse(Call<ProductRespond> call, Response<ProductRespond> response) {
                ProductRespond productRespond = response.body();
                SingleProduct[] products = productRespond.getProducts();
                ArrayList<ItemModel> itemModelArrayList =new ArrayList<>();
                for (int i = 0;i < 5;i++){
                    ItemModel itemModel = new ItemModel(R.drawable.cart,products[i].getTitle(),Double.parseDouble(products[i].getPrice()),products[i].getId());
                    itemModelArrayList.add(itemModel);
                }
                CategoryModel categoryModel = new CategoryModel("Newest Product " ,itemModelArrayList );
                arrayList.add(categoryModel);
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
                for (int i = 0;i < 5;i++){
                    ItemModel itemModel = new ItemModel(R.drawable.cart,products[i].getTitle(),Double.parseDouble(products[i].getPrice()),products[i].getId());
                    itemModelArrayList.add(itemModel);
                }
                CategoryModel categoryModel = new CategoryModel("Oldest Product " ,itemModelArrayList );
                arrayList.add(categoryModel);
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
                for (int i = 0;i < 5;i++){
                    ItemModel itemModel = new ItemModel(R.drawable.cart,products[i].getTitle(),Double.parseDouble(products[i].getPrice()),products[i].getId());
                    itemModelArrayList.add(itemModel);
                }
                CategoryModel categoryModel = new CategoryModel("Highest Product " ,itemModelArrayList );
                arrayList.add(categoryModel);
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
                for (int i = 0;i < 5;i++){
                    ItemModel itemModel = new ItemModel(R.drawable.cart,products[i].getTitle(),Double.parseDouble(products[i].getPrice()),products[i].getId());
                    itemModelArrayList.add(itemModel);
                }
                CategoryModel categoryModel = new CategoryModel("Lowest Product " ,itemModelArrayList );
                arrayList.add(categoryModel);
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
                for (int i = 0;i < 5;i++){
                    ItemModel itemModel = new ItemModel(R.drawable.cart,products[i].getTitle(),Double.parseDouble(products[i].getPrice()),products[i].getId());
                    itemModelArrayList.add(itemModel);
                }
                CategoryModel categoryModel = new CategoryModel("Most Popular Product " ,itemModelArrayList );
                arrayList.add(categoryModel);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductRespond> call, Throwable t) {

            }
        });

    }

}
