package org.hfut.pojo;

import java.util.Date;

public class SystemLog {
    private Integer id;

    private Date logTime;

    private String action;

    private Integer actionPeopleId;

    private Byte result;

    private String logMsg;

    private String errorMsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Integer getActionPeopleId() {
        return actionPeopleId;
    }

    public void setActionPeopleId(Integer actionPeopleId) {
        this.actionPeopleId = actionPeopleId;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg == null ? null : logMsg.trim();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }
}