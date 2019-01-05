package org.hfut.pojo;

public class SelectProjectFinancialmodeldetail {
    private Integer projectid;

    private Integer fincialmodeldetailid;

    private String name;

    private Double num;

    private Byte type;

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getFincialmodeldetailid() {
        return fincialmodeldetailid;
    }

    public void setFincialmodeldetailid(Integer fincialmodeldetailid) {
        this.fincialmodeldetailid = fincialmodeldetailid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}