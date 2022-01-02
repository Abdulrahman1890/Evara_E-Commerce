package com.example.evara;

import com.google.gson.annotations.SerializedName;

public class SubCategoryResponds {
    String errNum , msg;
    boolean status;
    @SerializedName("SubCategories")
    SubCategories[] subCategories;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public SubCategories[] getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(SubCategories[] subCategories) {
        this.subCategories = subCategories;
    }


}
