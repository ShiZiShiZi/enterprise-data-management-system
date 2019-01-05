package org.hfut.pojo;

import java.util.Date;

public class Systemlog {
    private Integer id;

    private Date logtime;

    private String action;

    private Integer actionpeopleid;

    private Byte result;

    private String logmsg;

    private String errormsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Integer getActionpeopleid() {
        return actionpeopleid;
    }

    public void setActionpeopleid(Integer actionpeopleid) {
        this.actionpeopleid = actionpeopleid;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public String getLogmsg() {
        return logmsg;
    }

    public void setLogmsg(String logmsg) {
        this.logmsg = logmsg == null ? null : logmsg.trim();
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg == null ? null : errormsg.trim();
    }
}