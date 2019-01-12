package org.hfut.pojo;

import java.util.Date;

public class SelectAllFinancialInformation {
    private Integer logId;

    private Double logNum;

    private Float taxRate;

    private Byte logType;

    private Date logTime;

    private Integer financialPeopleId;

    private Integer detailId;

    private String title;

    private Double detailNum;

    private Date detailTime;

    private Byte detailType;

    private Integer projectPeopleId;

    private Integer modelId;

    private String name;

    private Double modelNum;

    private Byte modelType;

    private Integer projectId;

    private Boolean active;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Double getLogNum() {
        return logNum;
    }

    public void setLogNum(Double logNum) {
        this.logNum = logNum;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    public Byte getLogType() {
        return logType;
    }

    public void setLogType(Byte logType) {
        this.logType = logType;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public Integer getFinancialPeopleId() {
        return financialPeopleId;
    }

    public void setFinancialPeopleId(Integer financialPeopleId) {
        this.financialPeopleId = financialPeopleId;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getDetailNum() {
        return detailNum;
    }

    public void setDetailNum(Double detailNum) {
        this.detailNum = detailNum;
    }

    public Date getDetailTime() {
        return detailTime;
    }

    public void setDetailTime(Date detailTime) {
        this.detailTime = detailTime;
    }

    public Byte getDetailType() {
        return detailType;
    }

    public void setDetailType(Byte detailType) {
        this.detailType = detailType;
    }

    public Integer getProjectPeopleId() {
        return projectPeopleId;
    }

    public void setProjectPeopleId(Integer projectPeopleId) {
        this.projectPeopleId = projectPeopleId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getModelNum() {
        return modelNum;
    }

    public void setModelNum(Double modelNum) {
        this.modelNum = modelNum;
    }

    public Byte getModelType() {
        return modelType;
    }

    public void setModelType(Byte modelType) {
        this.modelType = modelType;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}