package com.yuchai.maintain.evalmaintain.entity;
import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;

import java.lang.String;
@EnableGenerateResMap(classPath = "com.yuchai.maintain.evalmaintain.entity.EvalMgrYearV",xmlNames = {"EvalMgrYearMapper"})
    public class EvalMgrYearV{
    private String employeeLevel;
    private String employeeName;
    private String mgrCode;
    private String mgrName;
    private String orgFullName;
    private String statu;
    private String firstSubmit;
    private String evalYear;
    private String levelFirst;
    private String employeeCode;

    public String getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMgrCode() {
        return mgrCode;
    }

    public void setMgrCode(String mgrCode) {
        this.mgrCode = mgrCode;
    }

    public String getOrgFullName() {
        return orgFullName;
    }

    public void setOrgFullName(String orgFullName) {
        this.orgFullName = orgFullName;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getFirstSubmit() {
        return firstSubmit;
    }

    public void setFirstSubmit(String firstSubmit) {
        this.firstSubmit = firstSubmit;
    }

    public String getEvalYear() {
        return evalYear;
    }

    public void setEvalYear(String evalYear) {
        this.evalYear = evalYear;
    }

    public String getLevelFirst() {
        return levelFirst;
    }

    public void setLevelFirst(String levelFirst) {
        this.levelFirst = levelFirst;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }
}
