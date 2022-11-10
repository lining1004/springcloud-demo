package com.briup.demo11eurekazuul8888;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/*
*  1.当不配置任何路由规则： 默认代理所有的微服务实例
*   localhost:9001/test   访问项目资源
*   通过网关访问：
*   localhost:8888/serviceID/test
*  2.可以指定路由规则: routes :
*    指定访问路径可以映射到对应的服务中
*   /api/test/**   映射到 producer/**
*
*
* */
@EnableZuulProxy      // 开启网关代理
@EnableDiscoveryClient// 开启服务发现  serverId  网关  消费者
@SpringBootApplication
public class Demo11EurekaZuul8888Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo11EurekaZuul8888Application.class, args);
    }

}
