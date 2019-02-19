package com.yuchai.maintain.targetmaintain.mapper;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateXml;
import com.yuchai.maintain.targetmaintain.entity.TargetSelfDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@EnableGenerateXml(classPath = "com.yuchai.maintain.targetmaintain.mapper.TargetSelfMapper")
public interface TargetSelfMapper {

    //获取所有的自评时间节点
    List<TargetSelfDate> getAllSelfDatePoint();
    //获取所有权限是否打开
    int allAuthIsOpen();
    //打开/关闭所有的权限 0:打开 其它：关闭
    void changeAllAuth(@Param("value") Integer value);
    //修改自评时间节点
    void updateDatePoint(@Param("selfDateList") List<TargetSelfDate> selfDateList);



}
