package com.briup.demo09eurekahystrixfeign.web.controller;

import com.briup.demo09eurekahystrixfeign.web.rest.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lining
 * @Date 2022/11/10
 */
@RestController
public class HelloController {
    @Autowired
    private HelloRemote remote;  //注入的openFeign创建的对象
    @GetMapping("/hello")
    public String hello(){
        //实现远程调用producer服务中test请求
        return remote.test();
    }
}
