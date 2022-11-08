package com.briup.demo05eurekaconsumerribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author lining
 * @Date 2022/11/8
 */
@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced //开启负载均衡功能
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
