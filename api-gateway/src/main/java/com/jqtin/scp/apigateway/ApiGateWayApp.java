package com.jqtin.scp.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGateWayApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApp.class, args);
    }
}
