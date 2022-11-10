package com.briup.demo08eurekahystrixribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableHystrix         //开启熔断机制
@EnableDiscoveryClient //开启服务发现
@SpringBootApplication
public class Demo08EurekaHystrixRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo08EurekaHystrixRibbonApplication.class, args);
    }

    //本质上一个配置类，appConfig
    @LoadBalanced  //开启负载均衡：轮询每次访问集群中不同节点。
    @Bean  //restTemplate
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
