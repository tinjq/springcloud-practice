package com.jqtin.scp.providerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// @EnableDiscoveryClient // 该注解可以不加，见 EurekaClientAutoConfiguration
@SpringBootApplication
public class ProviderServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceApp.class, args);
    }
}
