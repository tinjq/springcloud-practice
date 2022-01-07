package com.jqtin.scp.feignconsumer.controller;

import com.jqtin.scp.feignconsumer.service.ProviderServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;

@Slf4j
@RestController
public class HelloController {

    @Resource
    private ProviderServiceFeign providerServiceFeign;

    @GetMapping("/hello")
    public String hello() {
        Instant s = Instant.now();
        String result = providerServiceFeign.hello();
        log.info("hello cost:{}ms", Duration.between(s, Instant.now()).toMillis());

        return result;
    }

}
