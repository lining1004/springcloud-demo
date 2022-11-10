package com.briup.demo10eurekasentinalfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients    //开启远程调用的客户端，实现发送请求
@EnableDiscoveryClient //开启服务发现》使用producer 微服务名称
@SpringBootApplication
public class Demo10EurekaSentinalFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo10EurekaSentinalFeignApplication.class, args);
    }

}
