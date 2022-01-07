package com.jqtin.scp.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "provider-service", fallbackFactory = ProviderServiceFeignFallbackFactory.class)
public interface ProviderServiceFeign {

    @GetMapping("/hello")
    String hello();
}
