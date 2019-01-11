package org.hfut.model;

/**
 * ProjectData
 *
 * @author WeiXin
 * @date 2019/1/11
 **/
public class ProjectData {

    private String name;
    private Double value;

    public ProjectData() {}

    public ProjectData(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
