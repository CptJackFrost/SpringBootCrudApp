package com.springbootcomapp.model;

public class Employee {
    private String empNumber;
    private String empName;
    private String position;

    public Employee() {

    }

    public Employee(String empNumber, String empName, String position) {
        this.empNumber = empNumber;
        this.empName = empName;
        this.position = position;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public String getEmpName() {
        return empName;
    }

    public String getPosition() {
        return position;
    }

    public void setEmpNumber(String empNo) {
        this.empNumber = empNo;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

