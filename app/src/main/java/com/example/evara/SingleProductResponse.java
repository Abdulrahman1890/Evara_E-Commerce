package com.example.evara;

import com.google.gson.annotations.SerializedName;

import org.w3c.dom.Comment;

public class SingleProductResponse {

    boolean status;
    String errNum , msg;
    @SerializedName("The Product")
    SingleProduct product;
    @SerializedName("the comments")
    Comments[] comments;

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

    public SingleProduct getProduct() {
        return product;
    }

    public void setProduct(SingleProduct product) {
        this.product = product;
    }

    public Comments[] getComments() {
        return comments;
    }

    public void setComments(Comments[] comments) {
        this.comments = comments;
    }
}
