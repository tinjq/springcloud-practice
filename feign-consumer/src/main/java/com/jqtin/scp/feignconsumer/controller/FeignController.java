package com.jqtin.scp.feignconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @GetMapping("/hello")
    public String hello() {
        return "Feign Hello.";
    }
}
