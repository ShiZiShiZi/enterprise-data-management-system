package org.hfut.pojo;

import java.util.Date;

public class ProjectPeopleFeedback {

    private Integer id;

    private Integer requestPeopleId;

    private Date requestTime;

    private Byte state;

    private Integer responsePeopeleId;

    private Date reesponseTime;

    private Integer targetPeopleId;

    private Integer targetDepartmentId;

    private Integer targetProjectId;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequestPeopleId() {
        return requestPeopleId;
    }

    public void setRequestPeopleId(Integer requestPeopleId) {
        this.requestPeopleId = requestPeopleId;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getResponsePeopeleId() {
        return responsePeopeleId;
    }

    public void setResponsePeopeleId(Integer responsePeopeleId) {
        this.responsePeopeleId = responsePeopeleId;
    }

    public Date getReesponseTime() {
        return reesponseTime;
    }

    public void setReesponseTime(Date reesponseTime) {
        this.reesponseTime = reesponseTime;
    }

    public Integer getTargetPeopleId() {
        return targetPeopleId;
    }

    public void setTargetPeopleId(Integer targetPeopleId) {
        this.targetPeopleId = targetPeopleId;
    }

    public Integer getTargetDepartmentId() {
        return targetDepartmentId;
    }

    public void setTargetDepartmentId(Integer targetDepartmentId) {
        this.targetDepartmentId = targetDepartmentId;
    }

    public Integer getTargetProjectId() {
        return targetProjectId;
    }

    public void setTargetProjectId(Integer targetProjectId) {
        this.targetProjectId = targetProjectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}