package com.mostafa.Model;

import com.mostafa.entity.User;

public class UserModel {
    private Long id;
    private String userName;
    private String name;
    private String email;
    private String dob;
    private String empTypeCode;
    private double payRate;
    private double salary;
    private double payCap;
    private String password;
    private String roleName;

    public UserModel setUserModel(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.name = user.getName();
        this.email = user.getEmail();
        this.dob = user.getDob();
        this.empTypeCode = user.getEmpType().getTypeCode();
        if(this.empTypeCode.equals("regular")){
            this.salary = user.getSalary();
        }

        if(this.empTypeCode.equals("part")){
            this.payRate = user.getPayRate();
            this.payCap = user.getPayCap();
        }
        this.roleName = user.getRole().getRoleName();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmpTypeCode() {
        return empTypeCode;
    }

    public void setEmpTypeCode(String empTypeCode) {
        this.empTypeCode = empTypeCode;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPayCap() {
        return payCap;
    }

    public void setPayCap(double payCap) {
        this.payCap = payCap;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
