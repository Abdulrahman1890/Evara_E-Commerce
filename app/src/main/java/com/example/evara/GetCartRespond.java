package com.example.evara;

import com.google.gson.annotations.SerializedName;

public class GetCartRespond {
    private boolean status;
    private String msg , errNum;
    @SerializedName("the cart")
    SingleCartItem[] singleCartItems;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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

    public SingleCartItem[] getSingleCartItems() {
        return singleCartItems;
    }

    public void setSingleCartItems(SingleCartItem[] singleCartItems) {
        this.singleCartItems = singleCartItems;
    }
}
