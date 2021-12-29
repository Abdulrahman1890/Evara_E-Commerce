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

public class HomeFragement extends Fragment {
    RecyclerView verticalRecyclerView;
    HomeVerticalAdapter adapter;
    ArrayList<VerticalModel> arrayList;
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
        setData();
        return view;
    }
    public void setData(){
        for (int i = 1; i <= 5;i++){
            VerticalModel verticalModel = new VerticalModel();
            verticalModel.setTitle("Title" + i);
            ArrayList<HorizontalModel> horizontalModelArrayList =new ArrayList<>();

            for (int j = 1;j <= 5;j++){
                HorizontalModel horizontalModel = new HorizontalModel();
                horizontalModel.setName("Name" + j);
                horizontalModel.setDescription("$ 3000");
                horizontalModelArrayList.add(horizontalModel);
            }
            verticalModel.setArrayList(horizontalModelArrayList);
            arrayList.add(verticalModel);
        }
        adapter.notifyDataSetChanged();
    }
}
