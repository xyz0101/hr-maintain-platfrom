package com.yuchai.maintain.salarymaintain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//允许事物管理
@EnableTransactionManagement
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("com.yuchai.maintain.salarymaintain.mapper")
public class SalaryMaintainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalaryMaintainApplication.class, args);
    }

}
