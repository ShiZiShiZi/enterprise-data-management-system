package org.hfut.pojo;

public class SelectPersonProject {
    private String title;

    private Integer id;

    private Integer projectpeopleid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectpeopleid() {
        return projectpeopleid;
    }

    public void setProjectpeopleid(Integer projectpeopleid) {
        this.projectpeopleid = projectpeopleid;
    }
}