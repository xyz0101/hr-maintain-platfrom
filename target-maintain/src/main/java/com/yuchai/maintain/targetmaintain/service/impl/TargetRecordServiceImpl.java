package com.yuchai.maintain.targetmaintain.service.impl;

import com.yuchai.maintain.targetmaintain.entity.EvalTargetsApply;
import com.yuchai.maintain.targetmaintain.mapper.TargetRecordMapper;
import com.yuchai.maintain.targetmaintain.service.TargetRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TargetRecordServiceImpl implements TargetRecordService {
    @Resource
    TargetRecordMapper targetMapper;


    @Override
    public List<EvalTargetsApply> getTargetApplyByYear(String year) {
        return targetMapper.getTargetApplyByYear(year);
    }
}
