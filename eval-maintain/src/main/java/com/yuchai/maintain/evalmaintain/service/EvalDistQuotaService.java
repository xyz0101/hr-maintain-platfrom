package com.yuchai.maintain.evalmaintain.service;

import com.yuchai.maintain.evalmaintain.entity.EvalDistQuota;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvalDistQuotaService {
    //获取指定年份的所有的评语分布率
    List<EvalDistQuota> getEvalDistQuotaByYear(@Param("year") String year);
    //删除指定年份的所有评语分布率
    void deleteEvalDistQuotaByYear(@Param("year") String year);
    //新增指定年份的评语分布率
    void addEvalDistQuotaWithYear(@Param("distQuotaList") List<EvalDistQuota> distQuotaList,String year);
    //修改评语分布率
    void updateEvalDistQuotaWithYear(@Param("distQuotaList") List<EvalDistQuota> distQuotaList);
}
