package org.hfut.pojo;

import java.util.Date;

public class FinancialDetail {
    private Integer id;

    private String title;

    private Double num;

    private Date time;

    private Integer financialModelId;

    private Byte type;

    private Integer projectPeopleId;

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

    public Integer getFinancialModelId() {
        return financialModelId;
    }

    public void setFinancialModelId(Integer financialModelId) {
        this.financialModelId = financialModelId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getProjectPeopleId() {
        return projectPeopleId;
    }

    public void setProjectPeopleId(Integer projectPeopleId) {
        this.projectPeopleId = projectPeopleId;
    }
}