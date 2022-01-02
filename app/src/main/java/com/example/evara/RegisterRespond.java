package com.example.evara;

import com.google.gson.annotations.SerializedName;

public class RegisterRespond {
    private Boolean status;
    private String errNum , msg;
    @SerializedName("User")
    private User user;

    public RegisterRespond() {
    }

    public RegisterRespond(Boolean status, String errNum, String msg, User user) {
        this.status = status;
        this.errNum = errNum;
        this.msg = msg;
        this.user = user;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
