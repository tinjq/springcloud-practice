package com.jqtin.scp.feignconsumer.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProviderServiceFeignFallbackFactory implements FallbackFactory<ProviderServiceFeign> {

    @Override
    public ProviderServiceFeign create(Throwable throwable) {
        log.error("ProviderServiceFeignFallbackFactory error.", throwable);

        return new ProviderServiceFeign() {
            @Override
            public String hello() {
                return "hello fallback.";
            }
        };
    }
}
