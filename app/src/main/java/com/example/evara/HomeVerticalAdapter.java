package com.example.evara;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeVerticalAdapter extends RecyclerView.Adapter<HomeVerticalAdapter.VerticalViewHolder> {
    Context context;
    ArrayList<VerticalModel> arrayList;

    public HomeVerticalAdapter(Context context,ArrayList<VerticalModel> arrayList){
        this.arrayList = arrayList;
        this.context = context;
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView title;
        Button more;
        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.card_horizontal_recycle_view);
            title = itemView.findViewById(R.id.card_title);
            more = itemView.findViewById(R.id.card_more);
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
        VerticalModel verticalModel = arrayList.get(position);
        String title = verticalModel.getTitle();
        ArrayList<HorizontalModel> singleItem = verticalModel.getArrayList();

        holder.title.setText(title);
        HorizontalHomeAdapter horizontalHomeAdapter = new HorizontalHomeAdapter(context,singleItem);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(horizontalHomeAdapter);
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,CatoGridView.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
