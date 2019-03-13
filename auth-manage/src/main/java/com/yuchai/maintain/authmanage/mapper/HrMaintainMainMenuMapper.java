package com.yuchai.maintain.authmanage.mapper;

import com.yuchai.maintain.authmanage.entity.HrMaintainMainMenu;

public interface HrMaintainMainMenuMapper {
    int deleteByPrimaryKey(Short mainMenuId);

    int insert(HrMaintainMainMenu record);

    int insertSelective(HrMaintainMainMenu record);

    HrMaintainMainMenu selectByPrimaryKey(Short mainMenuId);

    int updateByPrimaryKeySelective(HrMaintainMainMenu record);

    int updateByPrimaryKey(HrMaintainMainMenu record);
}