package com.example.evara;

import com.google.gson.annotations.SerializedName;

public class ProductByCategoryRespond {
    String msg , errNum;
    boolean status;

    @SerializedName("The Product")
    SingleProduct[] products;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrNum() {
        return errNum;
    }

    public void setErrNum(String errNum) {
        this.errNum = errNum;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public SingleProduct[] getProducts() {
        return products;
    }

    public void setProducts(SingleProduct[] products) {
        this.products = products;
    }
}
