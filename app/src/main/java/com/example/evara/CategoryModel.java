package com.example.evara;

import java.util.ArrayList;

public class CategoryModel {
    private String title;
    private ArrayList<ItemModel> arrayList;

    public CategoryModel(String title, ArrayList<ItemModel> arrayList) {
        this.title = title;
        this.arrayList = arrayList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ItemModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<ItemModel> arrayList) {
        this.arrayList = arrayList;
    }
}
