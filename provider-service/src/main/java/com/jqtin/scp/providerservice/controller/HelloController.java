package com.jqtin.scp.providerservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class HelloController {

    @Value("${spring.application.name}")
    private String serverName;

    @Value("${server.port}")
    private int port;

    @GetMapping("/hello")
    public String hello() throws Exception {
        // int a=10/0;//除数不能为0,这一行代码就会触发熔断

        String content = "Hello World, " + serverName + ":" + port;
        int sleepTime = new Random().nextInt(5000);
        log.info(content + ", sleepTime:" + sleepTime);
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        return content;
    }

    @GetMapping("/hello/{sleepTime}")
    public String helloSleepTime(@PathVariable("sleepTime") int sleepTime) throws Exception {
        String content = "Hello World, " + serverName + ":" + port;
        log.info(content + ", sleepTime:" + sleepTime);

        if (sleepTime > 10000) {
            throw new RuntimeException("hello exception");
        }
        TimeUnit.MILLISECONDS.sleep(sleepTime);

        return content;
    }
}
