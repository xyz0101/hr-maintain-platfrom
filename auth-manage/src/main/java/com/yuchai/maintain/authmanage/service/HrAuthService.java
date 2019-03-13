package com.yuchai.maintain.authmanage.service;

import com.yuchai.maintain.authmanage.entity.HrMaintainAuth;

import java.util.List;

public interface HrAuthService {
    public List<HrMaintainAuth> getAuth(String employeeCode);
}
