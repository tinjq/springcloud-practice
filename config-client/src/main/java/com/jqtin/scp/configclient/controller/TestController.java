package com.jqtin.scp.configclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;
    @Value("${spring.datasource.password:123}")
    private String dataSourcePassword;

    @RequestMapping("/from")
    public String from() {
        log.info("password:{}", dataSourcePassword);
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

}
