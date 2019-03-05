package com.yuchai.maintain.salarymaintain.mapper;

import com.alibaba.fastjson.JSONArray;
import com.yuchai.maintain.evalmaintain.anno.EnableGenerateXml;
import com.yuchai.maintain.salarymaintain.entity.SlrSpecialList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
@EnableGenerateXml(classPath = "com.yuchai.maintain.salarymaintain.mapper.SlrHolidayMapper")
public interface SlrSpecialListMapper {
    /**
     * 获取特殊人员工资项信息
     * @param
     * @return
     */
    List<SlrSpecialList> getSlrSpecialList();

    /**
     * 删除字段
     * @param list
     * @return
     */
    Integer deleteRecord(List<SlrSpecialList> list);

    /**
     * 更新字段
     * @param list
     * @return
     */
    Integer updateRecord(List<SlrSpecialList> list);

    /**
     * 增加字段
     * @param list
     * @return
     */
    Integer addRecord(List<SlrSpecialList> list);

}
