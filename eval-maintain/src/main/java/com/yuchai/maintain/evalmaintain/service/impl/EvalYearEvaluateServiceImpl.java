package com.yuchai.maintain.evalmaintain.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuchai.maintain.evalmaintain.entity.*;
import com.yuchai.maintain.evalmaintain.mapper.EvalIncludeEmployeesMapper;
import com.yuchai.maintain.evalmaintain.mapper.EvalMgrYearMapper;
import com.yuchai.maintain.evalmaintain.mapper.EvalYearEvaluateMapper;
import com.yuchai.maintain.evalmaintain.service.EvalYearEvaluateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.*;

@Service
public class EvalYearEvaluateServiceImpl implements EvalYearEvaluateService {
    Logger logger  = LoggerFactory.getLogger(EvalYearEvaluateServiceImpl.class);

    @Resource
    EvalYearEvaluateMapper evalMapper;
    @Resource
    EvalMgrYearMapper evalMgrYearMapperMapper;
    @Resource
    EvalIncludeEmployeesMapper evalIncludeEmployeesMapper;


    @Override
    public List<EvalYearEvaluate> getEvalByYear(String year) {
        return evalMapper.getEvalByYear(year);
    }

    @Override
    public List<EvalMgrYearV> getEvalYearByCondition(Map<String, Object> conditionMap) {
        return evalMgrYearMapperMapper.getEvalYearByCondition(conditionMap);
    }

    @Override
    public Integer getEvalYearByConditionCount(Map<String, Object> conditionMap) {
        return evalMgrYearMapperMapper.getEvalYearByConditionCount(conditionMap);
    }

    @Override
    @Transactional
    public void updateEvalMgrYear(String updateParams) {
        try{
            JSONArray ja = JSON.parseArray(updateParams);
            for(Object obj : ja) {
                JSONObject jo = (JSONObject) obj;
                //获取年份，编号以及是否上级是否还没有提交，false=Y，true=N/S
                String evalYear = String.valueOf(jo.get("evalYear"));
                String employeeCode = String.valueOf(jo.get("employeeCode"));
                Boolean isUnSubmit = (Boolean) jo.get("isUnSubmit");
                String firstSubmit = isUnSubmit ? "N" : "Y";

                evalMapper.updateEvalMgrYear(employeeCode,evalYear,firstSubmit);

            }


        }catch (RuntimeException e){
            e.printStackTrace();
            throw  e;

        }
        //return isSuccess;
    }

    @Override
    public List<EvalIncludeEmployees> getEvalEmployeeRange() {
        return evalIncludeEmployeesMapper.getEvalEmployeeRange();
    }

    @Override
    public void deleteEvalEmployeeRange() {
        evalIncludeEmployeesMapper.deleteEvalEmployeeRange();
    }

    @Override
    @Transactional
    public void addEvalEmployeeRange(List<EvalIncludeEmployees> emps) {
        if(emps!=null&&emps.size()>0) {
            //删除数据
            evalIncludeEmployeesMapper.deleteEvalEmployeeRange();
                evalIncludeEmployeesMapper.addEvalEmployeeRangeList(emps);
        }
    }

    @Override
    public Integer getEvalEmployeeCount() {
        return evalIncludeEmployeesMapper.getEvalEmployeeCount();
    }

    @Override
    public List<EvalEmployeeInfos> getEvalEmployeeInfosWithCondition(Map<String, Object> conditionMap) {
        return evalIncludeEmployeesMapper.getEvalEmployeeInfosWithCondition(conditionMap);
    }

    @Override
    public int getEvalEmployeeInfosCountWithCondition(Map<String, Object> conditionMap) {
        return evalIncludeEmployeesMapper.getEvalEmployeeInfosCountWithCondition(conditionMap);
    }

    @Override
    public int getAllEmpCount() {
        return evalIncludeEmployeesMapper.getAllEmpCount();
    }

    /**
     * 这里使用异步，避免用户占用会话时间太长
     * @param datePoint
     * @param executorUser
     * @param executorId
     */
    @Async
    public void refreshEvalData(Date datePoint, String executorUser ,String executorId){
        startRefresh(datePoint,executorUser,executorId);
    }

    @Override
    public EvalRefreshDataExecutor getExecutorByStatus(String status) {
        return evalMapper.getExecutorByStatus(status);
    }

    @Transactional
    public void startRefresh(Date datePoint, String executorUser,String executorId ){
        //开始刷新，检查是否有进程正在运行
        if(evalMapper.existExecutorByStatus(EvalRefreshDataExecutor.START)==0){
            //执行程序新增一条进程记录 状态为start
            EvalRefreshDataExecutor executor = new EvalRefreshDataExecutor();
            executor.setExecutorId(executorId);
            executor.setCreatedBy(executorUser);
            executor.setLastUpdatedBy(executorUser);
            executor.setExecutorStatus(EvalRefreshDataExecutor.START);
            createExecutor(executor);
            //开始执行
            Map<String,Object> params = new HashMap<>();
            Calendar cal = Calendar.getInstance();
            cal.setTime(datePoint);
            params.put("p_eval_year",cal.get(Calendar.YEAR)+"");
            params.put("p_data_date",datePoint);
            params.put("p_executor_id",executorId);
            params.put("p_auto_commit","Y");
            logger.info("刷新的参数======>"+params);

            evalIncludeEmployeesMapper.callExecuteRefresh(params);
            //执行完成，如果返回成功修改状态为success，如果有错则修改为exception
            String code = String.valueOf( params.get("x_rtn_code") );
            String info = String.valueOf(params.get("x_rtn_msg"));
            executor = evalMapper.getExecutorById(executorId);
            executor.setExecutorRtnCode(code);
            executor.setExecutorRtnInfo(info);
            executor.setExecutorStatus("S".equals(code)?EvalRefreshDataExecutor.SUCCESS:EvalRefreshDataExecutor.EXCEPTION);
            executor.setLastUpdatedBy(executorUser);
            evalMapper.updateExecutorStatusById(executor);


        }

    }
    @Override
    public boolean existExecutorByStatus(String status) {
        return evalMapper.existExecutorByStatus(EvalRefreshDataExecutor.START)>0;
    }

    @Override
    public void updateExecutorStatusById(EvalRefreshDataExecutor executor) {
        evalMapper.updateExecutorStatusById(executor);
    }

    @Override
    public EvalRefreshDataExecutor getExecutorById(String id) {
        return evalMapper.getExecutorById(id);
    }

    @Override
    public void createExecutor(EvalRefreshDataExecutor executor) {
        evalMapper.createExecutor(executor);
    }

    @Override
    public List<HrEmployeeInfoSync> getEmpByCodeOrName(String codeOrName) {
        return evalIncludeEmployeesMapper.getEmpByCodeOrName(codeOrName);
    }

    @Override
    @Transactional
    public void createNextYearEvaluate(Map<String, Object> conditionMap) {
        evalMapper.createNextYearEvaluate(conditionMap);
    }


}
