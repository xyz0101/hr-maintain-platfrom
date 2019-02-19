package com.yuchai.maintain.evalmaintain.entity;
import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;

import java.sql.Timestamp;
import java.lang.String;
import java.util.Date;

@EnableGenerateResMap(classPath = "com.yuchai.maintain.evalmaintain.entity.HrDeptRegion",xmlNames = {"DrOrgMapper"})
public class HrDeptRegion{
private String drCode;
private String lastUpdatedBy;
private String createdBy;
private Date lastUpdateDate;
private String drName;
private String drMgr;
private String drMgrName;
private Date creationDate;

    public String getDrCode() {
        return drCode;
    }

    public void setDrCode(String drCode) {
        this.drCode = drCode;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getDrMgr() {
        return drMgr;
    }

    public void setDrMgr(String drMgr) {
        this.drMgr = drMgr;
    }

    public String getDrMgrName() {
        return drMgrName;
    }

    public void setDrMgrName(String drMgrName) {
        this.drMgrName = drMgrName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "HrDeptRegion{" +
                "drCode='" + drCode + '\'' +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                ", drName='" + drName + '\'' +
                ", drMgr='" + drMgr + '\'' +
                ", drMgrName='" + drMgrName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
