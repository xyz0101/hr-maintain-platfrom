package com.yuchai.maintain.evalmaintain.service;

import com.yuchai.maintain.evalmaintain.entity.*;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EvalYearEvaluateService {
    public List<EvalYearEvaluate> getEvalByYear(  String year);
    List<EvalMgrYearV> getEvalYearByCondition(Map<String,Object> conditionMap);
    Integer getEvalYearByConditionCount(Map<String,Object> conditionMap );
    void updateEvalMgrYear( String  updateParams);
    List<EvalIncludeEmployees> getEvalEmployeeRange();
    void deleteEvalEmployeeRange();
    void addEvalEmployeeRange(List<EvalIncludeEmployees> emps);
    Integer getEvalEmployeeCount();

    //通过条件获取评价员工
    List<EvalEmployeeInfos> getEvalEmployeeInfosWithCondition(@Param("conditionMap") Map<String,Object> conditionMap);
    //通过条件获取评价员工总数
    int getEvalEmployeeInfosCountWithCondition(@Param("conditionMap") Map<String,Object> conditionMap);
    //获取所有的人员的总数
    int getAllEmpCount();
    //执行刷新程序
    void refreshEvalData(Date datePoint, String executorUser ,String executorId);

    //通过id来查询进程
    EvalRefreshDataExecutor getExecutorByStatus(@Param("status") String status);
    //通过状态查询进程是否存在
    boolean existExecutorByStatus(String status);
    //通过进程id来修改进程状态
    void updateExecutorStatusById(EvalRefreshDataExecutor executor);
    //通过id来查询进程
    EvalRefreshDataExecutor getExecutorById(@Param("id") String id);
    //创建一条进程记录
    void createExecutor(@Param("executor") EvalRefreshDataExecutor executor);

    //根据人员编号或姓名获取人员信息
    List<HrEmployeeInfoSync> getEmpByCodeOrName(@Param("codeOrName") String codeOrName);
    //生成下一年的年度评价年份
    void createNextYearEvaluate(Map<String,Object> conditionMap);
}
