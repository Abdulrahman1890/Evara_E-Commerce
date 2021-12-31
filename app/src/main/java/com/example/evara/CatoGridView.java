package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CatoGridView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HorizontalHomeAdapter adapter;
    private ArrayList<ItemModel> arrayList;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        recyclerView = findViewById(R.id.grid_view);
        layoutManager = new GridLayoutManager(getApplicationContext() , 3);
        recyclerView.setLayoutManager(layoutManager);

        arrayList = new ArrayList<ItemModel>();
        for (int i = 1;i <= 12; i++){
            ItemModel itemModel = new ItemModel(R.drawable.cart,"Name " + i,3000);
            arrayList.add(itemModel);
        }

        adapter = new HorizontalHomeAdapter(getApplicationContext(),arrayList);
        recyclerView.setAdapter(adapter);

    }
}