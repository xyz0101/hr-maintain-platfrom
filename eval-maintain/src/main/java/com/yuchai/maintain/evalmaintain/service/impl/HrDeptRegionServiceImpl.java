package com.yuchai.maintain.evalmaintain.service.impl;

import com.yuchai.maintain.evalmaintain.entity.HrDeptMgr;
import com.yuchai.maintain.evalmaintain.entity.HrDeptRegion;
import com.yuchai.maintain.evalmaintain.entity.HrDeptRegionDtl;
import com.yuchai.maintain.evalmaintain.entity.OrgInfo;
import com.yuchai.maintain.evalmaintain.mapper.DrOrgMapper;
import com.yuchai.maintain.evalmaintain.service.HrDeptRegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class HrDeptRegionServiceImpl implements HrDeptRegionService {
    Logger logger = LoggerFactory.getLogger(HrDeptRegionServiceImpl.class);
    @Resource
    DrOrgMapper mapper;
    @Override
    public List<HrDeptRegion> getHrDeptRegion() {
        return mapper.getHrDeptRegion();
    }

    @Override
    public List<HrDeptRegionDtl> getHrDeptRegionDtl(Date inputDate) {
        return mapper.getHrDeptRegionDtl(inputDate);
    }

    @Override
    public void addNewDeptRegion(List<HrDeptRegion> hrDeptRegions) {
        mapper.addNewDeptRegion(hrDeptRegions);
    }

    @Override
    public void addNewDeptRegionDtl(List<HrDeptRegionDtl> deptRegionDtls) {
        mapper.addNewDeptRegionDtl(deptRegionDtls);
    }

    @Override
    public void updateDeptRegion(List<HrDeptRegion> hrDeptRegions) {
        mapper.updateDeptRegion(hrDeptRegions);
    }

    @Override
    public void updateDeptRegionDtl(List<HrDeptRegionDtl> deptRegionDtls) {
        mapper.updateDeptRegionDtl(deptRegionDtls);
    }

    @Override
    public void deleteDeptRegion(List<HrDeptRegion> hrDeptRegions) {
        mapper.deleteDeptRegion(hrDeptRegions);
    }

    @Override
    public List<OrgInfo> getAllOrganization(Date inputDate) {
        return mapper.getAllOrganization(inputDate);
    }

    @Override
    @Transactional
    public void saveDeptRegion(List<HrDeptRegion> addHrDeptRegions, List<HrDeptRegion> deleteHrDeptRegions, List<HrDeptRegion> updateHrDeptRegions) {
        logger.info("开始保存"+"添加===>"+addHrDeptRegions+"  删除===>"+deleteHrDeptRegions+"  修改===>"+updateHrDeptRegions);
        if(addHrDeptRegions.size()>0)
        this.addNewDeptRegion(addHrDeptRegions);
        if(updateHrDeptRegions.size()>0)
        this.updateDeptRegion(updateHrDeptRegions);
        if(deleteHrDeptRegions.size()>0)
        this.deleteDeptRegion(deleteHrDeptRegions);
    }

    @Override
    @Transactional
    public void saveDeptRegionDtl(List<HrDeptRegionDtl> addHrDeptRegionDtls, List<HrDeptRegionDtl> deleteHrDeptRegionDtls, List<HrDeptRegionDtl> updateHrDeptRegionDtls) {
        logger.info("开始保存"+"添加===>"+addHrDeptRegionDtls+"  删除===>"+deleteHrDeptRegionDtls+"  修改===>"+updateHrDeptRegionDtls);
        if(addHrDeptRegionDtls.size()>0)
            this.addNewDeptRegionDtl(addHrDeptRegionDtls);
        if(updateHrDeptRegionDtls.size()>0)
            this.updateDeptRegionDtl(updateHrDeptRegionDtls);
        //if(deleteHrDeptRegionDtls.size()>0)
           // this.deleteHrDeptRegionDtls(deleteHrDeptRegionDtls);
    }

    @Override
    public List<HrDeptMgr> getDeptMgrs() {
        return mapper.getDeptMgrs();
    }

    @Override
    @Transactional
    public void updateDeptMgr(List<HrDeptMgr> hrDeptMgrs) {
        mapper.updateDeptMgr(hrDeptMgrs);
    }
}
