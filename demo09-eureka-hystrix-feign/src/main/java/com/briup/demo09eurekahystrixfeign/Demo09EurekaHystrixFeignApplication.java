package com.briup.demo09eurekahystrixfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//通过配置文件开启熔断机制
@EnableFeignClients     //开启feign客户端，创建接口的实现类
@EnableDiscoveryClient  //开启服务发现
@SpringBootApplication
public class Demo09EurekaHystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo09EurekaHystrixFeignApplication.class, args);
    }

}
