package org.hfut.pojo;

public class Contract {
    private Integer id;

    private String name;

    private byte[] contract;

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

    public byte[] getContract() {
        return contract;
    }

    public void setContract(byte[] contract) {
        this.contract = contract;
    }
}