package com.yuchai.maintain.targetmaintain.entity;

import com.yuchai.maintain.targetmaintain.anno.EnableGenerateResMap;

import java.math.BigDecimal;
 import java.lang.String;
import java.util.Date;
@EnableGenerateResMap(classPath = "com.yuchai.maintain.targetmaintain.entity.TargetSelfDate",xmlNames = {"TargetSelfMapper"})
public class TargetSelfDate{
    private String lastUpdatedBy;
    private BigDecimal objectVersionNumber;
    private Date endDate;
    private String createdBy;
    private Date lastUpdateDate;
    private String selfId;
    private String typeName;
    private String typeValue;
    private BigDecimal quarterNumber;
    private Date creationDate;
    private Date startDate;


    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public BigDecimal getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(BigDecimal objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getSelfId() {
        return selfId;
    }

    public void setSelfId(String selfId) {
        this.selfId = selfId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public BigDecimal getQuarterNumber() {
        return quarterNumber;
    }

    public void setQuarterNumber(BigDecimal quarterNumber) {
        this.quarterNumber = quarterNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
