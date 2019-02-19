package com.yuchai.maintain.evalmaintain.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util. Date;
import java.lang.String;
@EnableGenerateResMap(classPath = "com.yuchai.maintain.evalmaintain.entity.HrDeptRegionDtl",xmlNames = {"DrOrgMapper"})
public class HrDeptRegionDtl{
    private BigDecimal dtlId;
    private String drCode;
    private String drName;
    private String orgNameSecond;
    private String lastUpdatedBy;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date bdate;
    private String createdBy;
    private  Date lastUpdateDate;
    private String orgCodeSecond;
    private  Date creationDate;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date edate;

    public BigDecimal getDtlId() {
        return dtlId;
    }

    public void setDtlId(BigDecimal dtlId) {
        this.dtlId = dtlId;
    }

    public String getDrCode() {
        return drCode;
    }

    public void setDrCode(String drCode) {
        this.drCode = drCode;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getOrgNameSecond() {
        return orgNameSecond;
    }

    public void setOrgNameSecond(String orgNameSecond) {
        this.orgNameSecond = orgNameSecond;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public  Date getBdate() {
        return bdate;
    }

    public void setBdate( Date bdate) {
        this.bdate = bdate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public  Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate( Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getOrgCodeSecond() {
        return orgCodeSecond;
    }

    public void setOrgCodeSecond(String orgCodeSecond) {
        this.orgCodeSecond = orgCodeSecond;
    }

    public  Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate( Date creationDate) {
        this.creationDate = creationDate;
    }

    public  Date getEdate() {
        return edate;
    }

    public void setEdate( Date edate) {
        this.edate = edate;
    }
}
