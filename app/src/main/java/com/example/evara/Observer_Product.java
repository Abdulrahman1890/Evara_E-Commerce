package com.example.evara;

import android.widget.Toast;

import java.util.List;

public class Observer_Product implements Observer_evara{
    private String information;
    public void setinformation(String info)
    {
        this.information = info;
        notifytoallcustomer();
    }
    private List<Observers> customerlist;

    public void addcustomer(Observers observer)
    {
        customerlist.add(observer);
    }
    public void removecustomer(Observers observer)
    {
        customerlist.remove(observer);
    }
    public void notifytoallcustomer() {
        Toast.makeText(null, "notify all customers", Toast.LENGTH_SHORT).show();
    }
}
