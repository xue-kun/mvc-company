package com.xk.entity;

public class Emp {

    private Integer emp_id;
    private String name;
    private String sex;
    private String phone;
    private Integer salary;
    private Integer dept_id;
    private String dept_name;

    public Emp() {
    }

    public Emp(String name, String sex, String phone, Integer salary, Integer dept_id) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.salary = salary;
        this.dept_id = dept_id;
    }

    public Emp(Integer emp_id, String name, String sex, String phone, Integer salary, Integer dept_id) {
        this.emp_id = emp_id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.salary = salary;
        this.dept_id = dept_id;
    }

    public Emp(Integer emp_id, String name, String sex, String phone, Integer salary, Integer dept_id, String dept_name) {
        this.emp_id = emp_id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.salary = salary;
        this.dept_id = dept_id;
        this.dept_name = dept_name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", dept_id=" + dept_id +
                '}';
    }
}
