package com.example.evara;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter {
    ArrayList<HorizontalModel> arrayList;
    Context context;
    int resource;
    public GridViewAdapter(@NonNull Context context, int resource, ArrayList<HorizontalModel> arrayList) {
        super(context, resource);
        this.arrayList = arrayList;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resource,parent,false);
        ImageView imageView = view.findViewById(R.id.card_home_img);
        TextView name = view.findViewById(R.id.card_home_head);
        TextView price = view.findViewById(R.id.card_home_price);

        imageView.setImageResource(R.drawable.cart);
        name.setText(arrayList.get(position).getName());
        price.setText(arrayList.get(position).getDescription());


        return view;

    }
}
