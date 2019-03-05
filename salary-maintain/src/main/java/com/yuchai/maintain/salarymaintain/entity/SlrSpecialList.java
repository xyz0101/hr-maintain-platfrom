package com.yuchai.maintain.salarymaintain.entity;
import java.lang.String;

public class SlrSpecialList{
    private String specialType;

    private String employeeCode;

    private String salaryCode;

    private  String salaryName;

    private String employeeName;

    private Integer specialId;

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
    }

    public String getSalaryName() {
        return salaryName;
    }

    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getSalaryCode() {
        return salaryCode;
    }

    public void setSalaryCode(String salaryCode) {
        this.salaryCode = salaryCode;
    }
}
