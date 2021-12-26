package com.example.evara;

import android.widget.Toast;

public interface Observers {
    void action(String info);
    }
    class Customer implements Observers{
    public void action(String info){
        Toast.makeText(null,"informatiom sent", Toast.LENGTH_SHORT).show();
    }
}

