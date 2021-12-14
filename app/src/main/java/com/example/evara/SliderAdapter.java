package com.example.evara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    int[] images = {
            R.drawable.moto,R.drawable.cart,R.drawable.support
    };
    String[] headers = {
            "Buy Everything Easily" , "Save Your Money" , "Technical Support"
    };
    String[] bodies = {
            "Get everything you need easily through a simple and pleasant interface that will help you" ,
            "Save your money with continuous offers and discounts on all products" ,
            "Continuous technical support around the clock,  thus achieving the first item in credibility and integrity"
    };

    public SliderAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.page,container,false);
        ImageView img = view.findViewById(R.id.page_img);
        TextView head = view.findViewById(R.id.page_head);
        TextView body = view.findViewById(R.id.page_body);

        img.setImageResource(images[position]);
        head.setText(headers[position]);
        body.setText(bodies[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View)object);

    }
}
