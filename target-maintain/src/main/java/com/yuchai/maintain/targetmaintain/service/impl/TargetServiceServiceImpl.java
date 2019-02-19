package com.yuchai.maintain.targetmaintain.service.impl;

import com.yuchai.maintain.targetmaintain.entity.TargetSelfDate;
import com.yuchai.maintain.targetmaintain.mapper.TargetSelfMapper;
import com.yuchai.maintain.targetmaintain.service.TargetSelfService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TargetServiceServiceImpl implements TargetSelfService {
    @Resource
    private TargetSelfMapper selfMapper;

    @Override
    public List<TargetSelfDate> getAllSelfDatePoint() {
        return selfMapper.getAllSelfDatePoint();
    }

    @Override
    public boolean allAuthIsOpen() {
        return selfMapper.allAuthIsOpen()==0?true:false;
    }

    @Override
    @Transactional
    public void changeAllAuth(boolean value) {
        selfMapper.changeAllAuth(value?0:-1);
    }

    @Override
    @Transactional
    public void updateDatePoint(List<TargetSelfDate> selfDateList) {
        selfMapper.updateDatePoint(selfDateList);
    }
}
