package com.yuchai.maintain.targetmaintain.entity;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateResMap;

import java.util.Date;
@EnableGenerateResMap(classPath = "com.yuchai.maintain.targetmaintain.entity.EvalTargetsApply",xmlNames = {"TargetRecordMapper"})
public class EvalTargetsApply {

    private String employeeName;

    private String tarId;

    private String instanceId;

    private String tarTemplate;

    private String tarStatus;

    private Date tarFdate;

    private String selfResp;

    private String bizContent;

    private String q1thSelfAppr;

    private String q1thMgrAppr1;

    private String q1thMgrAppr2;

    private String q1thMgrAppr3;

    private String q1thStatus;

    private Date q1thFdate;

    private String q2thSelfAppr;

    private String q2thMgrAppr1;

    private String q2thMgrAppr2;

    private String q2thMgrAppr3;

    private String q2thStatus;

    private Date q2thFdate;

    private String q3thSelfAppr;

    private String q3thMgrAppr1;

    private String q3thMgrAppr2;

    private String q3thMgrAppr3;

    private String q3thStatus;

    private Date q3thFdate;

    private String q4thSelfAppr;

    private String q4thMgrAppr1;

    private String q4thMgrAppr2;

    private String q4thMgrAppr3;

    private String q4thStatus;

    private Date q4thFdate;

    private String createdBy;

    private Date creationDate;

    private String lastUpdatedBy;

    private Date lastUpdateDate;

    private String positionCode;

    private Short applyIndex;

    private String isEntrusted;

    private String editAuth;

    private String viewFlag;

    private String leaderStatus;

    private String orgResp;

    private String faceStatus;

    private String tarYear;

    private String employeeCode;

    private String hisFlag;

    public String getQ1t() {
        return q1t;
    }

    public void setQ1t(String q1t) {
        this.q1t = q1t ==null? null:q1t.trim();
    }

    public String getQ2t() {
        return q2t;
    }

    public void setQ2t(String q2t) {
        this.q2t = q2t ==null? null:q2t.trim();
    }

    public String getQ3t() {
        return q3t;
    }

    public void setQ3t(String q3t) {
        this.q3t = q3t ==null? null:q3t.trim();
    }

    public String getQ4t() {
        return q4t;
    }

    public void setQ4t(String q4t) {
        this.q4t = q4t ==null? null:q4t.trim();
    }

    private String q1t;

    private String q2t;

    private String q3t;

    private String q4t;

    private String endd1;

    private String endd2;

    private String endd3;

    private String flag1;
    private String flag2;
    private String flag3;
    private String flag4;//instanceid
    private String instanceid1;
    private String instanceid2;
    private String instanceid3;

    public String getInstanceid1() {
        return instanceid1;
    }

    public void setInstanceid1(String instanceid1) {
        this.instanceid1 = instanceid1;
    }

    public String getInstanceid2() {
        return instanceid2;
    }

    public void setInstanceid2(String instanceid2) {
        this.instanceid2 = instanceid2;
    }

    public String getInstanceid3() {
        return instanceid3;
    }

    public void setInstanceid3(String instanceid3) {
        this.instanceid3 = instanceid3;
    }

    public String getInstanceid4() {
        return instanceid4;
    }

    public void setInstanceid4(String instanceid4) {
        this.instanceid4 = instanceid4;
    }

    private String instanceid4;

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }

    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    public String getFlag3() {
        return flag3;
    }

    public void setFlag3(String flag3) {
        this.flag3 = flag3;
    }

    public String getFlag4() {
        return flag4;
    }

    public void setFlag4(String flag4) {
        this.flag4 = flag4;
    }

    public String getEndd1() {
        return endd1;
    }

    public void setEndd1(String endd1) {
        this.endd1 = endd1==null?null:endd1;
    }

    public String getEndd2() {
        return endd2;
    }

    public void setEndd2(String endd2) {
        this.endd2 = endd2==null?null:endd2;
    }

    public String getEndd3() {
        return endd3;
    }

    public void setEndd3(String endd3) {
        this.endd3 = endd3==null?null:endd3;
    }

    public String getEndd4() {
        return endd4;
    }

    public void setEndd4(String endd4) {
        this.endd4 = endd4==null?null:endd4;
    }

    private String endd4;

    public String getTarYear() {
        return tarYear;
    }

    public void setTarYear(String tarYear) {
        this.tarYear = tarYear == null ? null : tarYear.trim();
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    public String getHisFlag() {
        return hisFlag;
    }

    public void setHisFlag(String hisFlag) {
        this.hisFlag = hisFlag == null ? null : hisFlag.trim();
    }

    public String getTarId() {
        return tarId;
    }

    public void setTarId(String tarId) {
        this.tarId = tarId == null ? null : tarId.trim();
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId == null ? null : instanceId.trim();
    }

    public String getTarTemplate() {
        return tarTemplate;
    }

    public void setTarTemplate(String tarTemplate) {
        this.tarTemplate = tarTemplate == null ? null : tarTemplate.trim();
    }

    public String getTarStatus() {
        return tarStatus;
    }

    public void setTarStatus(String tarStatus) {
        this.tarStatus = tarStatus == null ? null : tarStatus.trim();
    }

    public Date getTarFdate() {
        return tarFdate;
    }

    public void setTarFdate(Date tarFdate) {
        this.tarFdate = tarFdate;
    }

    public String getSelfResp() {
        return selfResp;
    }

    public void setSelfResp(String selfResp) {
        this.selfResp = selfResp == null ? null : selfResp.trim();
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent == null ? null : bizContent.trim();
    }

    public String getQ1thSelfAppr() {
        return q1thSelfAppr;
    }

    public void setQ1thSelfAppr(String q1thSelfAppr) {
        this.q1thSelfAppr = q1thSelfAppr == null ? null : q1thSelfAppr.trim();
    }

    public String getQ1thMgrAppr1() {
        return q1thMgrAppr1;
    }

    public void setQ1thMgrAppr1(String q1thMgrAppr1) {
        this.q1thMgrAppr1 = q1thMgrAppr1 == null ? null : q1thMgrAppr1.trim();
    }

    public String getQ1thMgrAppr2() {
        return q1thMgrAppr2;
    }

    public void setQ1thMgrAppr2(String q1thMgrAppr2) {
        this.q1thMgrAppr2 = q1thMgrAppr2 == null ? null : q1thMgrAppr2.trim();
    }

    public String getQ1thMgrAppr3() {
        return q1thMgrAppr3;
    }

    public void setQ1thMgrAppr3(String q1thMgrAppr3) {
        this.q1thMgrAppr3 = q1thMgrAppr3 == null ? null : q1thMgrAppr3.trim();
    }

    public String getQ1thStatus() {
        return q1thStatus;
    }

    public void setQ1thStatus(String q1thStatus) {
        this.q1thStatus = q1thStatus == null ? null : q1thStatus.trim();
    }

    public Date getQ1thFdate() {
        return q1thFdate;
    }

    public void setQ1thFdate(Date q1thFdate) {
        this.q1thFdate = q1thFdate;
    }

    public String getQ2thSelfAppr() {
        return q2thSelfAppr;
    }

    public void setQ2thSelfAppr(String q2thSelfAppr) {
        this.q2thSelfAppr = q2thSelfAppr == null ? null : q2thSelfAppr.trim();
    }

    public String getQ2thMgrAppr1() {
        return q2thMgrAppr1;
    }

    public void setQ2thMgrAppr1(String q2thMgrAppr1) {
        this.q2thMgrAppr1 = q2thMgrAppr1 == null ? null : q2thMgrAppr1.trim();
    }

    public String getQ2thMgrAppr2() {
        return q2thMgrAppr2;
    }

    public void setQ2thMgrAppr2(String q2thMgrAppr2) {
        this.q2thMgrAppr2 = q2thMgrAppr2 == null ? null : q2thMgrAppr2.trim();
    }

    public String getQ2thMgrAppr3() {
        return q2thMgrAppr3;
    }

    public void setQ2thMgrAppr3(String q2thMgrAppr3) {
        this.q2thMgrAppr3 = q2thMgrAppr3 == null ? null : q2thMgrAppr3.trim();
    }

    public String getQ2thStatus() {
        return q2thStatus;
    }

    public void setQ2thStatus(String q2thStatus) {
        this.q2thStatus = q2thStatus == null ? null : q2thStatus.trim();
    }

    public Date getQ2thFdate() {
        return q2thFdate;
    }

    public void setQ2thFdate(Date q2thFdate) {
        this.q2thFdate = q2thFdate;
    }

    public String getQ3thSelfAppr() {
        return q3thSelfAppr;
    }

    public void setQ3thSelfAppr(String q3thSelfAppr) {
        this.q3thSelfAppr = q3thSelfAppr == null ? null : q3thSelfAppr.trim();
    }

    public String getQ3thMgrAppr1() {
        return q3thMgrAppr1;
    }

    public void setQ3thMgrAppr1(String q3thMgrAppr1) {
        this.q3thMgrAppr1 = q3thMgrAppr1 == null ? null : q3thMgrAppr1.trim();
    }

    public String getQ3thMgrAppr2() {
        return q3thMgrAppr2;
    }

    public void setQ3thMgrAppr2(String q3thMgrAppr2) {
        this.q3thMgrAppr2 = q3thMgrAppr2 == null ? null : q3thMgrAppr2.trim();
    }

    public String getQ3thMgrAppr3() {
        return q3thMgrAppr3;
    }

    public void setQ3thMgrAppr3(String q3thMgrAppr3) {
        this.q3thMgrAppr3 = q3thMgrAppr3 == null ? null : q3thMgrAppr3.trim();
    }

    public String getQ3thStatus() {
        return q3thStatus;
    }

    public void setQ3thStatus(String q3thStatus) {
        this.q3thStatus = q3thStatus == null ? null : q3thStatus.trim();
    }

    public Date getQ3thFdate() {
        return q3thFdate;
    }

    public void setQ3thFdate(Date q3thFdate) {
        this.q3thFdate = q3thFdate;
    }

    public String getQ4thSelfAppr() {
        return q4thSelfAppr;
    }

    public void setQ4thSelfAppr(String q4thSelfAppr) {
        this.q4thSelfAppr = q4thSelfAppr == null ? null : q4thSelfAppr.trim();
    }

    public String getQ4thMgrAppr1() {
        return q4thMgrAppr1;
    }

    public void setQ4thMgrAppr1(String q4thMgrAppr1) {
        this.q4thMgrAppr1 = q4thMgrAppr1 == null ? null : q4thMgrAppr1.trim();
    }

    public String getQ4thMgrAppr2() {
        return q4thMgrAppr2;
    }

    public void setQ4thMgrAppr2(String q4thMgrAppr2) {
        this.q4thMgrAppr2 = q4thMgrAppr2 == null ? null : q4thMgrAppr2.trim();
    }

    public String getQ4thMgrAppr3() {
        return q4thMgrAppr3;
    }

    public void setQ4thMgrAppr3(String q4thMgrAppr3) {
        this.q4thMgrAppr3 = q4thMgrAppr3 == null ? null : q4thMgrAppr3.trim();
    }

    public String getQ4thStatus() {
        return q4thStatus;
    }

    public void setQ4thStatus(String q4thStatus) {
        this.q4thStatus = q4thStatus == null ? null : q4thStatus.trim();
    }

    public Date getQ4thFdate() {
        return q4thFdate;
    }

    public void setQ4thFdate(Date q4thFdate) {
        this.q4thFdate = q4thFdate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy == null ? null : lastUpdatedBy.trim();
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode == null ? null : positionCode.trim();
    }

    public Short getApplyIndex() {
        return applyIndex;
    }

    public void setApplyIndex(Short applyIndex) {
        this.applyIndex = applyIndex;
    }

    public String getIsEntrusted() {
        return isEntrusted;
    }

    public void setIsEntrusted(String isEntrusted) {
        this.isEntrusted = isEntrusted == null ? null : isEntrusted.trim();
    }

    public String getEditAuth() {
        return editAuth;
    }

    public void setEditAuth(String editAuth) {
        this.editAuth = editAuth == null ? null : editAuth.trim();
    }

    public String getViewFlag() {
        return viewFlag;
    }

    public void setViewFlag(String viewFlag) {
        this.viewFlag = viewFlag == null ? null : viewFlag.trim();
    }

    public String getLeaderStatus() {
        return leaderStatus;
    }

    public void setLeaderStatus(String leaderStatus) {
        this.leaderStatus = leaderStatus == null ? null : leaderStatus.trim();
    }

    public String getOrgResp() {
        return orgResp;
    }

    public void setOrgResp(String orgResp) {
        this.orgResp = orgResp == null ? null : orgResp.trim();
    }

    public String getFaceStatus() {
        return faceStatus;
    }

    public void setFaceStatus(String faceStatus) {
        this.faceStatus = faceStatus == null ? null : faceStatus.trim();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null? null : employeeName.trim();
    }
}