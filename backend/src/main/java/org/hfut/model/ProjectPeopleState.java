package org.hfut.model;

/**
 * ProjectPeopleState
 *
 * @author WeiXin
 * @date 2019/1/12
 **/
public class ProjectPeopleState {

    private Integer projectPeopleId;
    private Byte state;

    public Integer getProjectPeopleId() {
        return projectPeopleId;
    }

    public void setProjectPeopleId(Integer projectPeopleId) {
        this.projectPeopleId = projectPeopleId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
