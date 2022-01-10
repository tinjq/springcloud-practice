package com.jqtin.scp.rabbitmqhello.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Component
public class Sender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send() {
        String content = "hello " + LocalDateTime.now();
        System.out.println("Sender:" + content);
        amqpTemplate.convertAndSend("hello", content);
    }
}
