package org.hfut.pojo;

import java.util.Date;

public class FinancialLog {
    private Integer id;

    private Double num;

    private Float taxRate;

    private Byte type;

    private Date time;

    private Integer financialDetailId;

    private Integer projectPeopleId;

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

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
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

    public Integer getFinancialDetailId() {
        return financialDetailId;
    }

    public void setFinancialDetailId(Integer financialDetailId) {
        this.financialDetailId = financialDetailId;
    }

    public Integer getProjectPeopleId() {
        return projectPeopleId;
    }

    public void setProjectPeopleId(Integer projectPeopleId) {
        this.projectPeopleId = projectPeopleId;
    }
}