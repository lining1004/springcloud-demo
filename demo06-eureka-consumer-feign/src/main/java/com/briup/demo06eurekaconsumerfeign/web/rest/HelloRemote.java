package com.briup.demo06eurekaconsumerfeign.web.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 表示该接口是一个feign客户端对象
 * @Author lining
 * @Date 2022/11/8
 */
@FeignClient(name = "producer") //设置由注册中心的producer服务提供
public interface HelloRemote {
    //调用producer服务中的方法 GET localhost:9001/test
    //重点强调；如果有参数要接收，必须使用@requestParam()
    @GetMapping("/test")
    String test();
}
