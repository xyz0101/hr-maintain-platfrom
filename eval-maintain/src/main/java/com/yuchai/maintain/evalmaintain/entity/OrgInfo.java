package com.yuchai.maintain.evalmaintain.entity;

public class OrgInfo {
    private String organizationCode;
    private String organizationName;

    public OrgInfo(String organizationCode, String organizationName) {
        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
    }
    public OrgInfo() {

    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
