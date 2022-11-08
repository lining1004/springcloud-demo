package com.briup.demo04consulproducer9002.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lining
 * @Date 2022/11/8
 */
@RestController
public class TestController {
    @Value("${server.port}")
    private int port;
    //该方法被其他微服务远程调用
    @GetMapping("/test")
    public String test(String username){
        return port+" hello "+username;
    }
}
