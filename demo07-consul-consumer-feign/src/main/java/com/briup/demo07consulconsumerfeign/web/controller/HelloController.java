package com.briup.demo07consulconsumerfeign.web.controller;

import com.briup.demo07consulconsumerfeign.web.rest.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过openFeign 远程调用producer 访问、/test资源
 * @Author lining
 * @Date 2022/11/8
 */
@RestController
public class HelloController {

    @Autowired
    private HelloRemote remote;

    @GetMapping("/hello")  //浏览器访问的路径
    public String hello(String username){
        return remote.test(username);
    }
}
