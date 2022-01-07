package com.jqtin.scp.hystrixconsumer.controller;

import com.jqtin.scp.hystrixconsumer.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        return helloService.hello();
    }

    @GetMapping("/hello/{sleepTime}")
    public String helloSleepTime(@PathVariable("sleepTime") int sleepTime) throws Exception {
        return helloService.hello(sleepTime);
    }
}
