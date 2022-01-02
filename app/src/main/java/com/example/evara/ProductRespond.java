package com.example.evara;

import com.google.gson.annotations.SerializedName;

public class ProductRespond {
    boolean status;
    String errNum ,msg;
    @SerializedName("Products")
    SingleProduct[] products;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getErrNum() {
        return errNum;
    }

    public void setErrNum(String errNum) {
        this.errNum = errNum;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SingleProduct[] getProducts() {
        return products;
    }

    public void setProducts(SingleProduct[] products) {
        this.products = products;
    }
}
