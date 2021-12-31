package com.jqtin.scp.ribbonconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class HelloController {

    private final RestTemplate restTemplate;

    public HelloController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello-via-url")
    public String helloViaUrl() {
        String result = null;
        try {
            result = restTemplate.getForObject("http://localhost:8081/hello", String.class);
        } catch (Exception e) {
            log.error("error: ", e);
        }

        if (result == null) {
            result = new RestTemplate().getForObject("http://localhost:8081/hello", String.class);
        }
        return result;
    }

    @GetMapping("/hello")
    public String hello() {
        return restTemplate.getForObject("http://provider-service/hello", String.class);
    }
}
