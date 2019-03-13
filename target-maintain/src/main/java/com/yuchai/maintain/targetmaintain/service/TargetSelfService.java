package com.yuchai.maintain.targetmaintain.service;

import com.yuchai.maintain.targetmaintain.entity.TargetSelfDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TargetSelfService {

    /**
     * 获取所有的自评时间节点
     * @return
     */
    List<TargetSelfDate> getAllSelfDatePoint();
    /**
     * 获取所有权限是否打开
     * @return
     */
    boolean allAuthIsOpen();
    /**
     * 打开/关闭所有的权限 0:打开 其它：关闭
     * @param value
     */
    void changeAllAuth(@Param("value") boolean value);
    /**
     * 修改自评时间节点
     * @param selfDateList
     */
    void updateDatePoint(@Param("selfDateList") List<TargetSelfDate> selfDateList);
}
