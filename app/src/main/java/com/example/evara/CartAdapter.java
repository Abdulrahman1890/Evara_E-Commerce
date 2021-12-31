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
        View itemView;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public ImageView getImg() {
            if(img == null)
                img = itemView.findViewById(R.id.cart_item_img);
            return img;
        }

        public TextView getHeader() {
            if(header == null)
                header = itemView.findViewById(R.id.cart_item_header);
            return header;
        }

        public TextView getPrice() {
            if(price == null)
                price = itemView.findViewById(R.id.cart_item_price);
            return price;
        }

        public TextView getQuantity() {
            if(quantity == null)
                quantity = itemView.findViewById(R.id.cart_item_quantity);
            return quantity;
        }

        public ImageButton getInc() {
            if(inc == null)
                inc = itemView.findViewById(R.id.cart_item_inc);
             return inc;
        }

        public ImageButton getDec() {
            if(dec == null)
                dec = itemView.findViewById(R.id.cart_item_dec);
            return dec;
        }

        public ImageButton getRemove() {
            if(remove == null)
                remove = itemView.findViewById(R.id.cart_item_delete);
            return remove;
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
        holder.getImg().setImageResource(itemCart.getImage());
        holder.getHeader().setText(itemCart.getHeader());
        holder.getPrice().setText("$ " + itemCart.getPrice());
        holder.getQuantity().setText(itemCart.getQuantity() + "");

        holder.getInc().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = itemCart.getQuantity() + 1;
                itemCart.setQuantity(quantity);
                notifyItemChanged(holder.getBindingAdapterPosition());
            }
        });
        holder.getDec().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = itemCart.getQuantity();
                if(quantity > 1)
                    quantity--;
                itemCart.setQuantity(quantity);
                notifyItemChanged(holder.getBindingAdapterPosition());
            }
        });
        holder.getRemove().setOnClickListener(new View.OnClickListener() {
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
