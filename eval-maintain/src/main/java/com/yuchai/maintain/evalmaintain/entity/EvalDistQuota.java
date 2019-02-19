package com.yuchai.maintain.evalmaintain.entity;
import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;
import com.yuchai.maintain.evalmaintain.anno.IgnoreInResultMap;
import com.yuchai.maintain.evalmaintain.anno.beananno.EnableExport;
import com.yuchai.maintain.evalmaintain.anno.beananno.EnableExportField;
import com.yuchai.maintain.evalmaintain.anno.beananno.ImportIndex;

import java.math.BigDecimal;
 import java.lang.String;
import java.util.Date;
 @EnableExport(fileName = "评语分布率")
@EnableGenerateResMap(classPath = "com.yuchai.maintain.evalmaintain.entity.EvalDistQuota",xmlNames = {"EvalDistQuotaMapper"})
public class EvalDistQuota{

    private BigDecimal aCal;

    private BigDecimal bCal;
    private String lastUpdatedBy;
    private BigDecimal objectVersionNumber;
    private String evalApplyNo;
    private BigDecimal dCal;
    private BigDecimal cCal;
    private Date lastUpdateDate;
    private Date creationDate;
    @EnableExportField(colName = "年份",colWidth = 90)
    @ImportIndex(index = 0)
    private String evalYear;
    @EnableExportField(colName = "等级",colWidth = 90)
    @ImportIndex(index = 1)
    private String jobLevel;
    @ImportIndex(index = 2)
    private String drCode;
    @ImportIndex(index = 3)
    private String deptNo;
    private BigDecimal sCal;
    private String quotaStat;


    @EnableExportField(colName = "线名称",colWidth = 250)
    @IgnoreInResultMap
    private String drName;
    @EnableExportField(colName = "部门名称",colWidth = 250)
    @IgnoreInResultMap
    private String deptName;
    @EnableExportField(colName = "S指标",colWidth = 90)
    @ImportIndex(index = 4)
    private BigDecimal sResult;
    @ImportIndex(index = 5)
    @EnableExportField(colName = "A指标",colWidth = 90)
    private BigDecimal aResult;
    @ImportIndex(index = 6)
    @EnableExportField(colName = "B指标",colWidth = 90)
    private BigDecimal bResult;
    private String createdBy;
    @ImportIndex(index = 7)
    @EnableExportField(colName = "C指标",colWidth = 90)
    private BigDecimal cResult;
    @ImportIndex(index = 8)
    @EnableExportField(colName = "D指标",colWidth = 90)
    private BigDecimal dResult;


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public BigDecimal getaCal() {
        return aCal;
    }

    public void setACal(BigDecimal aCal) {
        this.aCal = aCal;
    }

    public BigDecimal getdResult() {
        return dResult;
    }

    public void setDResult(BigDecimal dResult) {
        this.dResult = dResult;
    }

    public BigDecimal getbCal() {
        return bCal;
    }

    public void setBCal(BigDecimal bCal) {
        this.bCal = bCal;
    }

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

    public String getEvalApplyNo() {
        return evalApplyNo;
    }

    public void setEvalApplyNo(String evalApplyNo) {
        this.evalApplyNo = evalApplyNo;
    }

    public BigDecimal getdCal() {
        return dCal;
    }

    public void setDCal(BigDecimal dCal) {
        this.dCal = dCal;
    }

    public BigDecimal getcCal() {
        return cCal;
    }

    public void setCCal(BigDecimal cCal) {
        this.cCal = cCal;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public BigDecimal getbResult() {
        return bResult;
    }

    public void setBResult(BigDecimal bResult) {
        this.bResult = bResult;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getEvalYear() {
        return evalYear;
    }

    public void setEvalYear(String evalYear) {
        this.evalYear = evalYear;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(String jobLevel) {
        this.jobLevel = jobLevel;
    }

    public BigDecimal getsCal() {
        return sCal;
    }

    public void setSCal(BigDecimal sCal) {
        this.sCal = sCal;
    }

    public String getQuotaStat() {
        return quotaStat;
    }

    public void setQuotaStat(String quotaStat) {
        this.quotaStat = quotaStat;
    }

    public BigDecimal getsResult() {
        return sResult;
    }

    public void setSResult(BigDecimal sResult) {
        this.sResult = sResult;
    }

    public String getDrCode() {
        return drCode;
    }

    public void setDrCode(String drCode) {
        this.drCode = drCode;
    }

    public BigDecimal getaResult() {
        return aResult;
    }

    public void setAResult(BigDecimal aResult) {
        this.aResult = aResult;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public BigDecimal getcResult() {
        return cResult;
    }

    public void setCResult(BigDecimal cResult) {
        this.cResult = cResult;
    }

    @Override
    public String toString() {
        return "EvalDistQuota{" +
                "aCal=" + aCal +
                ", bCal=" + bCal +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", objectVersionNumber=" + objectVersionNumber +
                ", evalApplyNo='" + evalApplyNo + '\'' +
                ", dCal=" + dCal +
                ", cCal=" + cCal +
                ", lastUpdateDate=" + lastUpdateDate +
                ", creationDate=" + creationDate +
                ", evalYear='" + evalYear + '\'' +
                ", deptNo='" + deptNo + '\'' +
                ", jobLevel='" + jobLevel + '\'' +
                ", sCal=" + sCal +
                ", quotaStat='" + quotaStat + '\'' +
                ", drCode='" + drCode + '\'' +
                ", drName='" + drName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", sResult=" + sResult +
                ", aResult=" + aResult +
                ", bResult=" + bResult +
                ", createdBy='" + createdBy + '\'' +
                ", cResult=" + cResult +
                ", dResult=" + dResult +
                '}';
    }
}
