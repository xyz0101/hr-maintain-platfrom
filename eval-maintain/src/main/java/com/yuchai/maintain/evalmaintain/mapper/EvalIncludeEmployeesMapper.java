package com.yuchai.maintain.evalmaintain.mapper;

import com.yuchai.maintain.evalmaintain.anno.EnableGenerateXml;
import com.yuchai.maintain.evalmaintain.entity.EvalEmployeeInfos;
import com.yuchai.maintain.evalmaintain.entity.EvalIncludeEmployees;
import com.yuchai.maintain.evalmaintain.entity.HrEmployeeInfoSync;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@EnableGenerateXml(classPath = "com.yuchai.maintain.evalmaintain.mapper.EvalIncludeEmployeesMapper")
public interface EvalIncludeEmployeesMapper {

    List<EvalIncludeEmployees> getEvalEmployeeRange();
    void deleteEvalEmployeeRange();
    void addEvalEmployeeRange(@Param("emp") EvalIncludeEmployees  emp );
    void addEvalEmployeeRangeList(@Param("empList") List<EvalIncludeEmployees>  empList );
    Integer getEvalEmployeeCount();
    //通过条件获取评价员工
    List<EvalEmployeeInfos> getEvalEmployeeInfosWithCondition(@Param("conditionMap") Map<String,Object> conditionMap);
    //通过条件获取评价员工总数
    int getEvalEmployeeInfosCountWithCondition(@Param("conditionMap") Map<String,Object> conditionMap);
    //获取所有的人员的总数
    int getAllEmpCount();
    //调用刷新数据的存储过程
    void callExecuteRefresh(   Map<String,Object> conditionMap);
    //根据人员编号或姓名获取人员信息
    List<HrEmployeeInfoSync> getEmpByCodeOrName(@Param("codeOrName") String codeOrName);

}
