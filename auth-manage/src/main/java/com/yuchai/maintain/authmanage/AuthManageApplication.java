package com.yuchai.maintain.authmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.yuchai.maintain.authmanage.mapper")
public class AuthManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthManageApplication.class, args);
    }

}
