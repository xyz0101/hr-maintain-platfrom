package com.yuchai.maintain.authmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.yuchai.maintain.authmanage.mapper")
@EnableEurekaClient
public class AuthManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthManageApplication.class, args);
    }

}
