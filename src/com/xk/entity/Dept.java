package com.xk.entity;

public class Dept {

    private Integer dept_id;
    private String name;
    private String location;

    public Dept() {
    }

    public Dept(Integer dept_id, String name, String location) {
        this.dept_id = dept_id;
        this.name = name;
        this.location = location;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dept_id=" + dept_id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
