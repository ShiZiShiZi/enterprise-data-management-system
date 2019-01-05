package org.hfut.pojo;

import java.util.Date;

public class Financiallog {
    private Integer id;

    private Double num;

    private Float taxrate;

    private Byte type;

    private Date time;

    private Integer financialdetailid;

    private Integer projectpeopleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Float getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(Float taxrate) {
        this.taxrate = taxrate;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getFinancialdetailid() {
        return financialdetailid;
    }

    public void setFinancialdetailid(Integer financialdetailid) {
        this.financialdetailid = financialdetailid;
    }

    public Integer getProjectpeopleid() {
        return projectpeopleid;
    }

    public void setProjectpeopleid(Integer projectpeopleid) {
        this.projectpeopleid = projectpeopleid;
    }
}