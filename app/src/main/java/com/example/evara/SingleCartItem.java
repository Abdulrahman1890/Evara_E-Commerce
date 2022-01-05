package com.example.evara;

import com.google.gson.annotations.SerializedName;

public class SingleCartItem {
    private int id;
    private String product_id , quantity ,title , price , path;

    public int getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getPath() {
        return path;
    }
}
