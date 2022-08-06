package com.mostafa.entity;

import com.mostafa.Model.UserModel;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String userName;
    private String name;
    private String email;
    private String dob;

    @ManyToOne()
    @JoinColumn(name = "emp_type_id")
    private EmpType empType;
    private double payRate;
    private double salary;
    private double payCap;
    private String password;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    public User SetUser(UserModel model) {
        this.userName = model.getUserName();
        this.name = model.getName();
        this.email = model.getEmail();
        this.dob = model.getDob();
        if(model.getEmpTypeCode().equals("regular")){
            this.salary = model.getSalary();
        }

        if(model.getEmpTypeCode().equals("part")){
            this.payRate = model.getPayRate();
            this.payCap = model.getPayCap();
        }
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

    public EmpType getEmpType() {
        return empType;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
