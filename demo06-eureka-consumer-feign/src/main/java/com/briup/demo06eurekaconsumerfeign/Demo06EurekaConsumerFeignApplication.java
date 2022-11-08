package com.briup.demo06eurekaconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients  //开启feign客户端 动态代理为接口提供实现类对象
@EnableDiscoveryClient //开启服务发现功能，可以获取其他服务信息
@SpringBootApplication
public class Demo06EurekaConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo06EurekaConsumerFeignApplication.class, args);
    }

}
