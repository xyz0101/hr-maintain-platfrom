package com.yuchai.maintain.salarymaintain.service;

import com.alibaba.fastjson.JSONArray;
import com.yuchai.maintain.salarymaintain.entity.SlrSpecialList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlrSpecialListService {

    //获取特殊人员配置信息
    List<SlrSpecialList> querySpecialList();

    /**
     * 更新配置表信息
     * @param slrSpecialLists 需要修改的数据的集合
     * @return
     */
    Integer updateSpecialListInfo(List<SlrSpecialList> slrSpecialLists);

    /**
     * 增加配置表信息
     * @param slrSpecialLists 需要增加的数据的集合
     * @return
     */
    Integer addSpecialListInfo(List<SlrSpecialList> slrSpecialLists);

    /**
     * 删除配置表的数据
     * @param slrSpecialLists 需要删除的数据的集合
     * @return
     */
    Integer deleteSpecialListInfo(List<SlrSpecialList> slrSpecialLists);

    /**
     * 处理数据的变动
     * @param updateList
     * @param deleteList
     * @param addList
     * @return
     */
    Integer saveSpecialUpdate(List<SlrSpecialList> updateList,List<SlrSpecialList> deleteList ,List<SlrSpecialList> addList);

}
