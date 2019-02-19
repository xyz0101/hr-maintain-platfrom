package com.yuchai.maintain.targetmaintain.service;

import com.yuchai.maintain.targetmaintain.entity.TargetSelfDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TargetSelfService {

    //获取所有的自评时间节点
    List<TargetSelfDate> getAllSelfDatePoint();
    //获取所有权限是否打开
    boolean allAuthIsOpen();
    //打开/关闭所有的权限 0:打开 其它：关闭
    void changeAllAuth(@Param("value") boolean value);
    //修改自评时间节点
    void updateDatePoint(@Param("selfDateList") List<TargetSelfDate> selfDateList);
}
