package com.example.evara;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalHomeAdapter extends RecyclerView.Adapter<HorizontalHomeAdapter.HorizontalViewHolder> {

    Context context;
    ArrayList<HorizontalModel> arrayList;

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name , price;
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_home_img);
            name = itemView.findViewById(R.id.card_home_head);
            price = itemView.findViewById(R.id.card_home_price);

        }
    }

    public HorizontalHomeAdapter(Context context, ArrayList<HorizontalModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_of_horizontal_home,parent,false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        HorizontalModel horizontalModel = arrayList.get(position);
        holder.name.setText(horizontalModel.getName());
        holder.price.setText(horizontalModel.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Product.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
