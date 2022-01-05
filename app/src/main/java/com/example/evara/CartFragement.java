package com.example.evara;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragement extends Fragment {
    private RecyclerView recyclerView;
    private CartAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemCart> items;
    Bundle bundle;
    String token;
    ImageButton submit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragement,container,false);
        recyclerView = view.findViewById(R.id.cart_recycle_view);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        bundle = getArguments();
        token = bundle.getString("token");

        Call<GetCartRespond> getCartRespondCall = ApiClient.getInstance().getApi().GetCart(token);
        getCartRespondCall.enqueue(new Callback<GetCartRespond>() {
            @Override
            public void onResponse(Call<GetCartRespond> call, Response<GetCartRespond> response) {
                GetCartRespond getCartRespond = response.body();
                SingleCartItem[] product = getCartRespond.getSingleCartItems();
                items = new ArrayList<ItemCart>();
                int size = 0;
                if(product != null)
                    size = product.length;
                for (int i = 0; i < size; i++) {
                    items.add(new ItemCart(product[i].getPath(),product[i].getTitle(),Double.parseDouble(product[i].getPrice()),Integer.parseInt(product[i].getQuantity()),product[i].getId(),token));
                }
                adapter = new CartAdapter(items);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GetCartRespond> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        submit = view.findViewById(R.id.btn_submit_order);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(getContext(),Payment.class));
            }
        });

        return view;
    }
}
