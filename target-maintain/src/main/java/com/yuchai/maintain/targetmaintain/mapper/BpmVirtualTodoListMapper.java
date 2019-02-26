package com.yuchai.maintain.targetmaintain.mapper;

import com.yuchai.maintain.targetmaintain.entity.BpmVirtualTodoList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface BpmVirtualTodoListMapper {
    int insert(Map<String,String> map);

    List<BpmVirtualTodoList> selectByInstanceid(Map map);

    int insertSelective(Map map);

    int getMaxN();

    int deleteVirtProcess(Map map);
}