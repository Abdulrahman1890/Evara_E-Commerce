package com.example.evara;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchBar extends AppCompatActivity {

    
    EditText search;
    RecyclerView search_recycle_view;
    RecyclerView.LayoutManager layoutManager;
    HorizontalHomeAdapter adapter;
    String token;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);

        getSupportActionBar().hide();
        
        search = findViewById(R.id.searchbar_edt_txt);
        search_recycle_view = findViewById(R.id.search_recycle_view);
        bundle = getIntent().getExtras();
        layoutManager = new GridLayoutManager(getApplicationContext() , 3);
        search_recycle_view.setLayoutManager(layoutManager);
        token = bundle.getString("token");
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchProduct();

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        }



    public void searchProduct(){
        Call<ProductRespond> searchProductCall = ApiClient.getInstance().getApi().GetResultSearch(search.getText().toString());

        searchProductCall.enqueue(new Callback<ProductRespond>() {
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
                search_recycle_view.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductRespond> call, Throwable t) {

            }
        });

    }
}