package com.yuchai.maintain.targetmaintain.mapper;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateXml;
import com.yuchai.maintain.targetmaintain.entity.EvalTargetsApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@EnableGenerateXml(classPath = "com.yuchai.maintain.targetmaintain.mapper.TargetRecordMapper")

public interface TargetRecordMapper {
    public List<EvalTargetsApply> getTargetApplyByYear(@Param("year") String year);
}
