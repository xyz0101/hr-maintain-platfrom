package com.yuchai.maintain.authmanage.mapper;

import com.yuchai.maintain.authmanage.entity.HrMaintainAuth;

import java.util.List;

public interface HrMaintainAuthMapper {
    int deleteByPrimaryKey(Short authId);

    int insert(HrMaintainAuth record);

    int insertSelective(HrMaintainAuth record);

    HrMaintainAuth selectByPrimaryKey(Short authId);

    int updateByPrimaryKeySelective(HrMaintainAuth record);

    int updateByPrimaryKey(HrMaintainAuth record);

    List<HrMaintainAuth> getByEmployeeCode(String employeeCode);
}