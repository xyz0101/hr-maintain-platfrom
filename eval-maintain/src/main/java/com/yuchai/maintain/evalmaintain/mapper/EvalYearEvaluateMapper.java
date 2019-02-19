package com.yuchai.maintain.evalmaintain.mapper;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateXml;
import com.yuchai.maintain.evalmaintain.entity.EvalRefreshDataExecutor;
import com.yuchai.maintain.evalmaintain.entity.EvalYearEvaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@EnableGenerateXml(classPath = "com.yuchai.maintain.evalmaintain.mapper.EvalYearEvaluateMapper")
public interface EvalYearEvaluateMapper {

    List<EvalYearEvaluate> getEvalByYear(@Param("year") String year);
    Boolean updateEvalMgrYear(@Param("employeeCode") String employeeCode,@Param("evalYear") String evalYear,@Param("firstSubmit") String firstSubmit);
    //通过状态查询进程是否存在
    int existExecutorByStatus(@Param("status") String status);
    //通过进程id来修改进程状态
    void updateExecutorStatusById(@Param("executor") EvalRefreshDataExecutor executor);
    //通过id来查询进程
    EvalRefreshDataExecutor getExecutorById(@Param("id") String id);
    //通过id来查询进程
    EvalRefreshDataExecutor getExecutorByStatus(@Param("status") String status);
    //创建一条进程记录
    void createExecutor(@Param("executor") EvalRefreshDataExecutor executor);

    //生成下一年的年度评价年份
    void createNextYearEvaluate(Map<String,Object> conditionMap);
}
