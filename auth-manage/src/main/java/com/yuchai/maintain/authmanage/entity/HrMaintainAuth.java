package com.yuchai.maintain.authmanage.entity;

import java.util.List;

public class HrMaintainAuth {
    private Short authId;

    private String employeeCode;

    private String roleCode;

    private String roleDesc;

    private Short mainMenuId;

    HrMaintainMainMenu  mainMenu;

    public HrMaintainMainMenu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(HrMaintainMainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public Short getAuthId() {
        return authId;
    }

    public void setAuthId(Short authId) {
        this.authId = authId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public Short getMainMenuId() {
        return mainMenuId;
    }

    public void setMainMenuId(Short mainMenuId) {
        this.mainMenuId = mainMenuId;
    }
}