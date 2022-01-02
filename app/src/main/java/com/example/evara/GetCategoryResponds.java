package com.example.evara;

import com.google.gson.annotations.SerializedName;

public class GetCategoryResponds {
    boolean status;
    String errNum , msg;
    @SerializedName("All_Categories")
    All_Categories[] all_categories;

    public GetCategoryResponds(boolean status, String errNum, String msg, All_Categories[] all_categories) {
        this.status = status;
        this.errNum = errNum;
        this.msg = msg;
        this.all_categories = all_categories;
    }

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

    public All_Categories[] getAll_categories() {
        return all_categories;
    }

    public void setAll_categories(All_Categories[] all_categories) {
        this.all_categories = all_categories;
    }
}
