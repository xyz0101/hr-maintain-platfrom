package com.yuchai.maintain.evalmaintain.entity;
import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;
import com.yuchai.maintain.evalmaintain.anno.beananno.EnableExport;
import com.yuchai.maintain.evalmaintain.anno.beananno.EnableExportField;
import com.yuchai.maintain.evalmaintain.anno.beananno.ImportIndex;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.lang.String;
@EnableGenerateResMap(classPath = "com.yuchai.maintain.evalmaintain.entity.EvalIncludeEmployees",xmlNames = {"EvalIncludeEmployeesMapper"})
@EnableExport(fileName = "评价员工范围")
public class EvalIncludeEmployees{
    private String lastUpdatedBy;
    private BigDecimal objectVersionNumber;
    private String createdBy;
    private Timestamp lastUpdateDate;
    private Timestamp creationDate;
    @ImportIndex(index = 0)
    @EnableExportField(colName = "员工编号",colWidth = 120)
    private String employeeCode;
    @EnableExportField(colName = "员工姓名",colWidth = 120)
    private String employeeName;
    @ImportIndex(index = 2)
    @EnableExportField(colName = "是否参与评价",colWidth = 200)
    private String isEnable;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        return "EvalIncludeEmployees{" +
                "employeeCode='" + employeeCode + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", isEnable='" + isEnable + '\'' +
                '}';
    }
}
