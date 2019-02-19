package com.yuchai.maintain.evalmaintain.mapper;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateXml;
import com.yuchai.maintain.evalmaintain.entity.EvalMgrYearV;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@EnableGenerateXml(classPath = "com.yuchai.maintain.evalmaintain.mapper.EvalMgrYearMapper")
public interface EvalMgrYearMapper {
    List<EvalMgrYearV> getEvalYearByCondition(@Param("conditionMap") Map<String,Object> conditionMap );
    Integer getEvalYearByConditionCount(@Param("conditionMap") Map<String,Object> conditionMap );
}
