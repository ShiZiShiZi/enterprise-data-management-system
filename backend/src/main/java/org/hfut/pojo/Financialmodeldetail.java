package org.hfut.pojo;

public class Financialmodeldetail {
    private Integer id;

    private String name;

    private Double num;

    private Byte type;

    private Integer financialmodelid;

    private Boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getFinancialmodelid() {
        return financialmodelid;
    }

    public void setFinancialmodelid(Integer financialmodelid) {
        this.financialmodelid = financialmodelid;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}