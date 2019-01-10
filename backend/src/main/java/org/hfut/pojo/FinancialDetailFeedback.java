package org.hfut.pojo;

import java.util.Date;

public class FinancialDetailFeedback {

    private Integer financialDetailId;

    private Date requestTime;

    private Integer responsePeopleId;

    private Date responseTime;

    private Byte state;

    private String description;

    public Integer getFinancialDetailId() {
        return financialDetailId;
    }

    public void setFinancialDetailId(Integer financialDetailId) {
        this.financialDetailId = financialDetailId;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Integer getResponsePeopleId() {
        return responsePeopleId;
    }

    public void setResponsePeopleId(Integer responsePeopleId) {
        this.responsePeopleId = responsePeopleId;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
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