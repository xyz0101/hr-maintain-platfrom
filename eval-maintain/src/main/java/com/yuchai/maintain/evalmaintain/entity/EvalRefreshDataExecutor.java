package com.yuchai.maintain.evalmaintain.entity;
import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;
import com.yuchai.maintain.evalmaintain.anno.IgnoreInResultMap;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
@EnableGenerateResMap(classPath = "com.yuchai.maintain.evalmaintain.entity.EvalRefreshDataExecutor",xmlNames = {"EvalYearEvaluateMapper"})
public class EvalRefreshDataExecutor{

    private String lastUpdatedBy;
    private BigDecimal objectVersionNumber;
    private String executorStatus;
    private String executorId;
    private String createdBy;
    private Date lastUpdateDate;
    private String att03;
    private String executorRtnInfo;
    private String executorRtnCode;
    private Date creationDate;
    private String att02;
    private String att01;
    @IgnoreInResultMap
    public static final String START="start";
    @IgnoreInResultMap
    public static final String SUCCESS="success";
    @IgnoreInResultMap
    public static final String EXCEPTION="exception";

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

    public String getExecutorStatus() {
        return executorStatus;
    }

    public void setExecutorStatus(String executorStatus) {
        this.executorStatus = executorStatus;
    }

    public String getExecutorId() {
        return executorId;
    }

    public void setExecutorId(String executorId) {
        this.executorId = executorId;
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

    public String getAtt03() {
        return att03;
    }

    public void setAtt03(String att03) {
        this.att03 = att03;
    }

    public String getExecutorRtnInfo() {
        return executorRtnInfo;
    }

    public void setExecutorRtnInfo(String executorRtnInfo) {
        this.executorRtnInfo = executorRtnInfo;
    }

    public String getExecutorRtnCode() {
        return executorRtnCode;
    }

    public void setExecutorRtnCode(String executorRtnCode) {
        this.executorRtnCode = executorRtnCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAtt02() {
        return att02;
    }

    public void setAtt02(String att02) {
        this.att02 = att02;
    }

    public String getAtt01() {
        return att01;
    }

    public void setAtt01(String att01) {
        this.att01 = att01;
    }
}
