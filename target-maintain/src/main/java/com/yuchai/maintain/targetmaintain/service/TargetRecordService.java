package com.yuchai.maintain.targetmaintain.service;




import com.yuchai.maintain.targetmaintain.entity.EvalTargetsApply;

import java.util.List;
import java.util.Map;

public interface TargetRecordService {
    public List<EvalTargetsApply> getTargetApplyByYear(String year);

    public List<EvalTargetsApply> queryEmpEvalInfo(String year);

    public Map<String,Object> selectEnddate(String qN);
}
