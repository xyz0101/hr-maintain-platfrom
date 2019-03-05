package com.yuchai.maintain.salarymaintain.service;

import com.yuchai.maintain.salarymaintain.entity.EmpBaseInfo;

import java.util.List;

public interface EmpBaseInfoService {
    // 获取员工号和员工姓名
    public List<EmpBaseInfo> getEmpBaseInfo(String employeeCode);
}
