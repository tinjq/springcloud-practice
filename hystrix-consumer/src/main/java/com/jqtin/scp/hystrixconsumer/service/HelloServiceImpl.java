package com.jqtin.scp.hystrixconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey", ignoreExceptions = Exception.class)
    @Override
    public String hello() {
        long start = System.currentTimeMillis();
        String result = restTemplate.getForObject("http://provider-service/hello", String.class);
        long end = System.currentTimeMillis();
        log.info("Hystrix hello Spend time:{}ms", (end - start));

        return result;
    }

    @HystrixCommand(fallbackMethod = "helloSleepTimeFallback", commandKey = "helloKey", ignoreExceptions = Exception.class)
    @Override
    public String hello(int sleepTime) {
        if (sleepTime < 0) {
            throw new RuntimeException("client exception");
        }

        long start = System.currentTimeMillis();
        String result = restTemplate.getForObject("http://provider-service/hello/{sleepTime}", String.class, sleepTime);
        long end = System.currentTimeMillis();
        log.info("Hystrix helloSleepTimeFallback Spend time:{}ms", (end - start));

        return result;
    }

    private String helloFallback(Throwable throwable) {
        log.error("hello error:", throwable);
        return "helloFallback";
    }

    private String helloSleepTimeFallbackFallback(int sleepTime, Throwable throwable) {
        log.error("hello error:", throwable);
        return "helloSleepTimeFallback";
    }
}
