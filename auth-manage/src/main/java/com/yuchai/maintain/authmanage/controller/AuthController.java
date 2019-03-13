package com.yuchai.maintain.authmanage.controller;

import com.yuchai.maintain.authmanage.entity.HrMaintainAuth;
import com.yuchai.maintain.authmanage.service.HrAuthService;
import com.yuchai.maintain.authmanage.service.impl.HrAuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    HrAuthService service;

    @RequestMapping("/getAuth")
    public List<HrMaintainAuth> getAuth(String employeeCode){
        return service.getAuth(employeeCode);
    }
}
