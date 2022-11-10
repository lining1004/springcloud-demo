package com.briup.demo03eurekaproducer9001.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lining
 * @Date 2022/11/8
 */
@RestController
public class TestController {
    @Value("${server.port}")//获取application.yml中配置信息
    private int port;//端口号；为了区分相同的请求，因为使用ribbon进行负载均衡操作，导致轮询的方式分别向3个服务器请求
    /**
     * 单体架构中 浏览器请求  GET localhost:9001/test
     * 微服务架构： 其他的微服务远程调用当前服务提供方法
     *  GET localhost:9001/test
     *
     * @return
     */

    @GetMapping("/test")
    public String test() throws Exception{
        //模拟服务B长时间处理
        //Thread.sleep(10000); //阻塞10s
        return "hello world "+port;
    }
}
