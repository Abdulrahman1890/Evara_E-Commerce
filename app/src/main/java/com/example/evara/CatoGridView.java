package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class CatoGridView extends AppCompatActivity {
    GridView gridView;
    GridViewAdapter horizontalHomeAdapter;
    ArrayList<HorizontalModel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.grid_view);
        arrayList = new ArrayList<HorizontalModel>();
        for (int i = 0;i < 6;i++){
            HorizontalModel horizontalModel = new HorizontalModel();
            horizontalModel.setName("Title");
            horizontalModel.setDescription("$ 3000");
            arrayList.add(horizontalModel);
        }
        horizontalHomeAdapter = new GridViewAdapter(getApplicationContext(),R.layout.card_of_horizontal_home,arrayList);
        gridView.setAdapter(horizontalHomeAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),Product.class);
                startActivity(intent);
            }
        });
    }
}