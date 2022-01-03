package com.example.evara;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeVerticalAdapter extends RecyclerView.Adapter<HomeVerticalAdapter.VerticalViewHolder> {
    private Context context;
    private ArrayList<CategoryModel> arrayList;

    public HomeVerticalAdapter(Context context,ArrayList<CategoryModel> arrayList){
        this.arrayList = arrayList;
        this.context = context;
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView recyclerView;
        private TextView categoryName;
        private Button more;
        private View itemView;
        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public RecyclerView getRecyclerView() {
            if(recyclerView == null)
                recyclerView = itemView.findViewById(R.id.card_horizontal_recycle_view);
            return recyclerView;
        }

        public TextView getCategoryName() {
            if(categoryName == null)
                categoryName = itemView.findViewById(R.id.card_title);
            return categoryName;
        }

        public Button getMore() {
            if(more == null)
                more = itemView.findViewById(R.id.card_more);
            return more;
        }
    }
    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_of_vertical_home,parent,false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        CategoryModel categoryModel = arrayList.get(position);
        String title = categoryModel.getTitle();
        ArrayList<ItemModel> singleItem = categoryModel.getArrayList();

        holder.getCategoryName().setText(title);
        HorizontalHomeAdapter horizontalHomeAdapter = new HorizontalHomeAdapter(context,singleItem);
        holder.getRecyclerView().setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.getRecyclerView().setAdapter(horizontalHomeAdapter);
        holder.getMore().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),CatoGridView.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title);
                bundle.putString("token",singleItem.get(0).getToken());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
