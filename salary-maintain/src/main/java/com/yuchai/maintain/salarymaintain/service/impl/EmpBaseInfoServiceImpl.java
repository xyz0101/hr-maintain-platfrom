package com.yuchai.maintain.salarymaintain.service.impl;

import com.yuchai.maintain.salarymaintain.entity.EmpBaseInfo;
import com.yuchai.maintain.salarymaintain.mapper.EmpBaseInfoMapper;
import com.yuchai.maintain.salarymaintain.service.EmpBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpBaseInfoServiceImpl implements EmpBaseInfoService{
    @Autowired
    EmpBaseInfoMapper empBaseInfoMapper;
    @Override
    public List<EmpBaseInfo> getEmpBaseInfo(String employeeCode) {
        return empBaseInfoMapper.selectEmpBaseInfo(employeeCode);
    }
}
