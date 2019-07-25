package domain;

public class ResultInfo {
    private boolean flag;
    private String errormsg;
    private Object data;
    private String msg;

    public Object getData() {
        return data;
    }


    public boolean getFlag(){
        return flag;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
