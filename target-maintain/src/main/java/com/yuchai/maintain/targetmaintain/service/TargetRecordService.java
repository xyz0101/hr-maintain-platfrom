package com.yuchai.maintain.targetmaintain.service;




import com.yuchai.maintain.targetmaintain.entity.EvalTargetsApply;

import java.util.List;

public interface TargetRecordService {
    public List<EvalTargetsApply> getTargetApplyByYear(String year);
}
