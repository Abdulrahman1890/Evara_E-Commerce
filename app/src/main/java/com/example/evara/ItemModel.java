package com.example.evara;

public class ItemModel {
    private String img ;
    int id;
    private String name;
    private double price;
    private String token;

    public ItemModel(String img, String name, double price , int id,String token) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.id = id;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
