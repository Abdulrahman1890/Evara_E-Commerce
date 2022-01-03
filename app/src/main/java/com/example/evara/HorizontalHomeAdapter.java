package com.example.evara;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalHomeAdapter extends RecyclerView.Adapter<HorizontalHomeAdapter.SimpleItemViewHolder> {

    Context context;
    ArrayList<ItemModel> arrayList;

    public static class SimpleItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name , price;
        private View itemView;
        public SimpleItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public ImageView getImg() {
            if(img == null)
                img = itemView.findViewById(R.id.card_home_img);
            return img;
        }

        public TextView getName() {
            if(name == null)
                name = itemView.findViewById(R.id.card_home_head);
            return name;
        }

        public TextView getPrice() {
            if(price == null)
                price = itemView.findViewById(R.id.card_home_price);
            return price;
        }
    }

    public HorizontalHomeAdapter(Context context, ArrayList<ItemModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public SimpleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_of_horizontal_home,parent,false);
        return new SimpleItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleItemViewHolder holder, int position) {
        ItemModel itemModel = arrayList.get(position);
        holder.getImg().setImageResource(itemModel.getImg());
        holder.getName().setText(itemModel.getName());
        holder.getPrice().setText("$ " + itemModel.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Product.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",itemModel.getId());
                bundle.putString("token",itemModel.getToken());
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
