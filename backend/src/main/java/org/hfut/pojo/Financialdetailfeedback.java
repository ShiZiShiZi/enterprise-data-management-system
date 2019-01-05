package org.hfut.pojo;

import java.util.Date;

public class Financialdetailfeedback {
    private Integer financialdetailid;

    private Date requesttime;

    private Integer projectpeopleid;

    private Date audittime;

    private Byte state;

    private String description;

    public Integer getFinancialdetailid() {
        return financialdetailid;
    }

    public void setFinancialdetailid(Integer financialdetailid) {
        this.financialdetailid = financialdetailid;
    }

    public Date getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Date requesttime) {
        this.requesttime = requesttime;
    }

    public Integer getProjectpeopleid() {
        return projectpeopleid;
    }

    public void setProjectpeopleid(Integer projectpeopleid) {
        this.projectpeopleid = projectpeopleid;
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}