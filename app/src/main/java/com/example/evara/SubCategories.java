package com.example.evara;

import com.google.gson.annotations.SerializedName;

public class SubCategories {
    int id;
    String category ;
    @SerializedName("sub_category_name")
    String subCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return subCategory;
    }
}
