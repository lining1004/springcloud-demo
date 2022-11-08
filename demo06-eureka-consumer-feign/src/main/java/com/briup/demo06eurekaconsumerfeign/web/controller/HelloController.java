package com.briup.demo06eurekaconsumerfeign.web.controller;

import com.briup.demo06eurekaconsumerfeign.web.rest.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lining
 * @Date 2022/11/8
 */
@RestController
public class HelloController {
    @Autowired
    private HelloRemote remote;
    @GetMapping("/hello")
    public String hello(){
        //1.使用restTemplate对象远程调用服务producer中的请求
        //2.使用OpenFeign实现远程调用
        return remote.test();
    }
}

