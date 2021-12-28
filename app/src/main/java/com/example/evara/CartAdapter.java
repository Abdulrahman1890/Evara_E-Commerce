package com.example.evara;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    ArrayList<ItemCart> items;

    public static class CartViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView header , price , quantity;
        private ImageButton inc , dec , remove;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cart_item_img);
            header = itemView.findViewById(R.id.cart_item_header);
            price = itemView.findViewById(R.id.cart_item_price);
            quantity = itemView.findViewById(R.id.cart_item_quantity);
            inc = itemView.findViewById(R.id.cart_item_inc);
            dec = itemView.findViewById(R.id.cart_item_dec);
            remove = itemView.findViewById(R.id.cart_item_delete);
        }
    }

    public CartAdapter(ArrayList<ItemCart> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_of_cart,parent,false);
        CartViewHolder cartViewHolder = new CartViewHolder(view);
        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        ItemCart itemCart = items.get(position);
        holder.img.setImageResource(itemCart.getImage());
        holder.header.setText(itemCart.getHeader());
        holder.price.setText("$ " + itemCart.getPrice());
        holder.quantity.setText(itemCart.getQuantity() + "");

        holder.inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = itemCart.getQuantity() + 1;
                itemCart.setQuantity(quantity);
                notifyItemChanged(holder.getBindingAdapterPosition());
            }
        });
        holder.dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = itemCart.getQuantity();
                if(quantity > 1)
                    quantity--;
                itemCart.setQuantity(quantity);
                notifyItemChanged(holder.getBindingAdapterPosition());
            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(holder.getBindingAdapterPosition());
                notifyItemRemoved(holder.getBindingAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
