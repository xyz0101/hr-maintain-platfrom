package com.yuchai.maintain.authmanage.service.impl;

import com.yuchai.maintain.authmanage.entity.HrMaintainAuth;
import com.yuchai.maintain.authmanage.mapper.HrMaintainAuthMapper;
import com.yuchai.maintain.authmanage.mapper.HrMaintainMainMenuMapper;
import com.yuchai.maintain.authmanage.service.HrAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HrAuthServiceImpl implements HrAuthService {
    @Resource
    HrMaintainAuthMapper hrMaintainAuthMapper;

    public List<HrMaintainAuth> getAuth(String employeeCode){
       return hrMaintainAuthMapper.getByEmployeeCode(employeeCode);
    }

}
