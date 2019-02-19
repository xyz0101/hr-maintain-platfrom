package com.yuchai.maintain.evalmaintain.mapper;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateXml;
import com.yuchai.maintain.evalmaintain.entity.EvalDistQuota;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@EnableGenerateXml(classPath = "com.yuchai.maintain.evalmaintain.mapper.EvalDistQuotaMapper")
public interface EvalDistQuotaMapper {

    //获取指定年份的所有的评语分布率
    List<EvalDistQuota> getEvalDistQuotaByYear(@Param("year") String year);
    //删除指定年份的所有评语分布率
    void deleteEvalDistQuotaByYear(@Param("year") String year);
    //新增指定年份的评语分布率
    void addEvalDistQuotaWithYear(@Param("distQuotaList") List<EvalDistQuota> distQuotaList);
    //修改评语分布率
    void updateEvalDistQuotaWithYear(@Param("distQuotaList") List<EvalDistQuota> distQuotaList);

}
