package com.yuchai.maintain.evalmaintain.entity;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;

import java.util.Date;
@EnableGenerateResMap(classPath = "com.yuchai.maintain.evalmaintain.entity.EvalEmployeeInfos",xmlNames = {"EvalIncludeEmployeesMapper"})
public class EvalEmployeeInfos {

    private Date dataDate;
    private String employeeCode;
    private String employeeName;
    private String orgNameSecond;
    private String positionName;

    public Date getDataDate() {
        return dataDate;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getOrgNameSecond() {
        return orgNameSecond;
    }

    public void setOrgNameSecond(String orgNameSecond) {
        this.orgNameSecond = orgNameSecond;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
