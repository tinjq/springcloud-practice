package com.jqtin.scp.hystrixconsumer.service;

public interface HelloService {

    String hello();

    String hello(int sleepTime) throws Exception;
}
