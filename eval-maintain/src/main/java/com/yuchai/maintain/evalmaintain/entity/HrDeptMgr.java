package com.yuchai.maintain.evalmaintain.entity;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;

@EnableGenerateResMap(classPath = "com.yuchai.maintain.evalmaintain.entity.HrDeptMgr",xmlNames = {"DrOrgMapper"})
public class HrDeptMgr {
    private String organizationCode;
    private String organizationName;
    private String leaderCode;
    private String leaderName;

    public String getLeaderCode() {
        return leaderCode;
    }

    public void setLeaderCode(String leaderCode) {
        this.leaderCode = leaderCode;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
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
