package com.yuchai.maintain.evalmaintain.service;

import com.yuchai.maintain.evalmaintain.entity.HrDeptMgr;
import com.yuchai.maintain.evalmaintain.entity.HrDeptRegion;
import com.yuchai.maintain.evalmaintain.entity.HrDeptRegionDtl;
import com.yuchai.maintain.evalmaintain.entity.OrgInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface HrDeptRegionService {
    //查询所有线
    List<HrDeptRegion> getHrDeptRegion();
    //查询所有的线与部门的关系
    List<HrDeptRegionDtl> getHrDeptRegionDtl(Date inputDate);
    //新增线
    void addNewDeptRegion(@Param("hrDeptRegions") List<HrDeptRegion> hrDeptRegions);
    //新增线与部门的关系
    void addNewDeptRegionDtl(@Param("deptRegionDtls") List<HrDeptRegionDtl> deptRegionDtls );
    //修改线
    void updateDeptRegion(@Param("hrDeptRegions") List<HrDeptRegion> hrDeptRegions);
    //修改线与部门关系
    void updateDeptRegionDtl(@Param("deptRegionDtls") List<HrDeptRegionDtl> deptRegionDtls );
    //删除线
    void deleteDeptRegion(@Param("hrDeptRegions") List<HrDeptRegion> hrDeptRegions);
    //获取所有的部门以供选择
    List<OrgInfo> getAllOrganization(@Param("inputDate")Date inputDate);
    //保存线的操作
    void saveDeptRegion(List<HrDeptRegion> addHrDeptRegions,List<HrDeptRegion> deleteHrDeptRegions,List<HrDeptRegion> updateHrDeptRegions);
    //保存线与部门关系的操作
    void saveDeptRegionDtl(List<HrDeptRegionDtl> addHrDeptRegionDtls,List<HrDeptRegionDtl> deleteHrDeptRegionDtls,List<HrDeptRegionDtl> updateHrDeptRegionDtls);

    //获取部门的领导对应关系
    List<HrDeptMgr> getDeptMgrs();
    //修改部门领导关系
    void updateDeptMgr(List<HrDeptMgr> hrDeptMgrs);



}
