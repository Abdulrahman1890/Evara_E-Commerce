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

public class CartFragement extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ItemCart> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragement,container,false);
        recyclerView = view.findViewById(R.id.cart_recycle_view);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        items = new ArrayList<ItemCart>();
        items.add(new ItemCart(R.drawable.cart,"cart car",3000,1));
        items.add(new ItemCart(R.drawable.cart,"cart car",3000,1));
        items.add(new ItemCart(R.drawable.cart,"cart car",3000,1));
        items.add(new ItemCart(R.drawable.cart,"cart car",3000,1));
        items.add(new ItemCart(R.drawable.cart,"cart car",3000,1));
        items.add(new ItemCart(R.drawable.cart,"cart car",3000,1));
        adapter = new CartAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
