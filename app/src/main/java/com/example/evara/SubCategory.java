package com.example.evara;

public class SubCategory {
    String category_id, sub_category_name, category, category_image;
    int id;

    public String getCategory_id() {
        return category_id;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    public String getCategory() {
        return category;
    }

    public String getCategory_image() {
        return category_image;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return sub_category_name;
    }
}
