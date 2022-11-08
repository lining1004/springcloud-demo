package com.briup.demo05eurekaconsumerribbon.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 当前服务A是通过浏览器访问的。
 * 浏览器---->A ----->B
 * @Author lining
 * @Date 2022/11/8
 */
@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/hello")
    public String hello(){
        //使用RESTtemplate通过远程调用服务B实现返回字符串
        //通过注册中心获取producer注册实例的ip+port
        String url = "http://producer/test";//
        //String url = "http://localhost:9001/test";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}
