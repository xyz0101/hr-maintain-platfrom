package com.yuchai.maintain.evalmaintain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//允许事物管理
@EnableTransactionManagement
@SpringBootApplication
//作为服务允许被发现
@EnableDiscoveryClient
//mybatis包扫描路径
@MapperScan("com.yuchai.maintain.evalmaintain.mapper")
@EnableAsync
public class EvalMaintainApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvalMaintainApplication.class, args);
    }

}

