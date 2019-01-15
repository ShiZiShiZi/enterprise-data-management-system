package org.hfut.pojo;

public class Department {
    private Integer id;

    private String name;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Department) {
            Department department = (Department)obj;
            return id.intValue() == department.getId() && this.name.equals(department.getName());
        }
        return super.equals(obj);
    }
}