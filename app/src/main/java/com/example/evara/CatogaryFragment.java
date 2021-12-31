package com.example.evara;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class CatogaryFragment extends Fragment {
    RecyclerView recyclerView;
    HorizontalHomeAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemModel> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_catogary,container,false);

        recyclerView = view.findViewById(R.id.catogary_recycle_view);
        layoutManager = new GridLayoutManager(getContext() , 3);
        recyclerView.setLayoutManager(layoutManager);

        arrayList = new ArrayList<ItemModel>();
        for (int i = 1;i <= 12; i++){
            ItemModel itemModel = new ItemModel(R.drawable.cart,"Name " + i,3000);
            arrayList.add(itemModel);
        }

        adapter = new HorizontalHomeAdapter(getContext(),arrayList);
        recyclerView.setAdapter(adapter);

        return view;
    }

}