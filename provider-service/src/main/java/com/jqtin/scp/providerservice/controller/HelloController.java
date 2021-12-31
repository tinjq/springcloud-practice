package com.jqtin.scp.providerservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Value("${spring.application.name}")
    private String serverName;

    @Value("${server.port}")
    private int port;

    @GetMapping("/hello")
    public String hello() {
        String content = "Hello World, " + serverName + ":" + port;
        log.info(content);
        return content;
    }
}
