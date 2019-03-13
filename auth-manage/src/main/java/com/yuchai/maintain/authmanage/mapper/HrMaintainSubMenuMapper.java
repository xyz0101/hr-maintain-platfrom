package com.yuchai.maintain.authmanage.mapper;

import com.yuchai.maintain.authmanage.entity.HrMaintainSubMenu;

import java.util.List;

public interface HrMaintainSubMenuMapper {
    int deleteByPrimaryKey(Short subMenuId);

    int insert(HrMaintainSubMenu record);

    int insertSelective(HrMaintainSubMenu record);

    HrMaintainSubMenu selectByPrimaryKey(Short subMenuId);

    List<HrMaintainSubMenu> selectByMainMenuId(Short mainMenuId);

    int updateByPrimaryKeySelective(HrMaintainSubMenu record);

    int updateByPrimaryKey(HrMaintainSubMenu record);
}