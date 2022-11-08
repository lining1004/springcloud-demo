package com.briup.demo05eurekaconsumerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //开启服务发现功能 获取到注册到服务中心的服务B的信息
@SpringBootApplication
public class Demo05EurekaConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo05EurekaConsumerRibbonApplication.class, args);
    }

}
