package org.hfut.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SelectGetFeedbackList {
    private String projectTitle;

    private String title;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date requestTime;

    private Byte state;

    private String description;

    private Integer projectPeopleId;

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle == null ? null : projectTitle.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getProjectPeopleId() {
        return projectPeopleId;
    }

    public void setProjectPeopleId(Integer projectPeopleId) {
        this.projectPeopleId = projectPeopleId;
    }
}