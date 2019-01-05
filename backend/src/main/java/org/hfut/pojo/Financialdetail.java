package org.hfut.pojo;

import java.util.Date;

public class Financialdetail {
    private Integer id;

    private String title;

    private Double num;

    private Date time;

    private Integer financialmodeldetailid;

    private Byte type;

    private Integer projectpeopleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getFinancialmodeldetailid() {
        return financialmodeldetailid;
    }

    public void setFinancialmodeldetailid(Integer financialmodeldetailid) {
        this.financialmodeldetailid = financialmodeldetailid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getProjectpeopleid() {
        return projectpeopleid;
    }

    public void setProjectpeopleid(Integer projectpeopleid) {
        this.projectpeopleid = projectpeopleid;
    }
}