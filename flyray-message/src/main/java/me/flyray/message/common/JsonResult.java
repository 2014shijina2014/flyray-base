package me.flyray.message.common;

/** 
* @author: bolei
* @date：Jul 14, 2017 5:28:08 PM 
* @description：类描述
*/

public class JsonResult {
    private boolean success;
    private String status;
    private String msg;
    private Object obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}

