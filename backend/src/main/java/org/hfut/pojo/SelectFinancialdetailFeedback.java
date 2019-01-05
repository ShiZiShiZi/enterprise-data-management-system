package org.hfut.pojo;

import java.util.Date;

public class SelectFinancialdetailFeedback {

    private Integer projectpeopleid;

    private String projectpeoplename;

    private Integer projectid;

    private String projecttitle;

    private Integer detailid;

    private String detailtitle;

    private Byte detailtype;

    private Date requesttime;

    private Byte state;

    private String description;

    private Date audittime;

    private Integer reviewerid;

    public Integer getProjectpeopleid() {
        return projectpeopleid;
    }

    public void setProjectpeopleid(Integer projectpeopleid) {
        this.projectpeopleid = projectpeopleid;
    }

    public String getProjectpeoplename() {
        return projectpeoplename;
    }

    public void setProjectpeoplename(String projectpeoplename) {
        this.projectpeoplename = projectpeoplename == null ? null : projectpeoplename.trim();
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjecttitle() {
        return projecttitle;
    }

    public void setProjecttitle(String projecttitle) {
        this.projecttitle = projecttitle == null ? null : projecttitle.trim();
    }

    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public String getDetailtitle() {
        return detailtitle;
    }

    public void setDetailtitle(String detailtitle) {
        this.detailtitle = detailtitle == null ? null : detailtitle.trim();
    }

    public Byte getDetailtype() {
        return detailtype;
    }

    public void setDetailtype(Byte detailtype) {
        this.detailtype = detailtype;
    }

    public Date getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Date requesttime) {
        this.requesttime = requesttime;
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

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public Integer getReviewerid() {
        return reviewerid;
    }

    public void setReviewerid(Integer reviewerid) {
        this.reviewerid = reviewerid;
    }
}