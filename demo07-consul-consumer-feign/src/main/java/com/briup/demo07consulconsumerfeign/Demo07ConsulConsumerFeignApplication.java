package com.briup.demo07consulconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //开启客户端
@EnableDiscoveryClient //开启服务发现
@SpringBootApplication
public class Demo07ConsulConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo07ConsulConsumerFeignApplication.class, args);
    }

}
