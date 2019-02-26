package com.yuchai.maintain.targetmaintain.service.impl;

import com.yuchai.maintain.targetmaintain.entity.EvalTargetsApply;
import com.yuchai.maintain.targetmaintain.mapper.TargetRecordMapper;
import com.yuchai.maintain.targetmaintain.service.TargetRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TargetRecordServiceImpl implements TargetRecordService {
    @Resource
    TargetRecordMapper targetMapper;


    @Override
    public List<EvalTargetsApply> getTargetApplyByYear(String year) {
        return targetMapper.getTargetApplyByYear(year);
    }

    @Override
    public List<EvalTargetsApply> queryEmpEvalInfo(String year) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("year",year);
        map.put("q1",year+"年第一季度自评");
        map.put("q2",year+"年第二季度自评");
        map.put("q3",year+"年第三季度自评");
        map.put("q4",year+"年第四季度自评");
        List<EvalTargetsApply> list =targetMapper.getEmpEvalDetInfo(map);
        return list;
    }

    @Override
    public Map<String,Object> selectEnddate(String qN) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("typevalue","template1self");
        map.put("qnumber",qN);
        String type1 = targetMapper.selectEnddateByQ(map);
        map.put("typevalue","template2self");
        map.put("qnumber",qN);
        String type2 = targetMapper.selectEnddateByQ(map);
        map.clear();
        map.put("type1",type1);
        map.put("type2",type2);
        return map;
    }
}
