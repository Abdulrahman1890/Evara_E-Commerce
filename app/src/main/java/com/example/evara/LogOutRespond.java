package com.example.evara;

public class LogOutRespond {
    private String msg;
    private String errNum;
    private boolean status;

    public LogOutRespond(String msg, String errNum, boolean status) {
        this.msg = msg;
        this.errNum = errNum;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
