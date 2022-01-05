package com.example.evara;

import com.google.gson.annotations.SerializedName;

public class GetSubcategoriesByIdRespond {
    boolean status;
    String errNum,msg;
    @SerializedName("products")
    SubCategory[] subCategory;

    public boolean isStatus() {
        return status;
    }

    public String getErrNum() {
        return errNum;
    }

    public String getMsg() {
        return msg;
    }

    public SubCategory[] getSubCategory() {
        return subCategory;
    }
}
