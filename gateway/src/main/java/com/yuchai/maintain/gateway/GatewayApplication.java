package com.yuchai.maintain.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
Logger logger = LoggerFactory.getLogger(GatewayApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        logger.info("进入网关");
//        return builder.routes()
//                .route(p -> p.path("/eval")
//                .uri("http://127.0.0.1:8762"))
//                .route(p -> p.path("/target")
//                .uri("http://127.0.0.1:8763"))
//                .build();
//    }
}

