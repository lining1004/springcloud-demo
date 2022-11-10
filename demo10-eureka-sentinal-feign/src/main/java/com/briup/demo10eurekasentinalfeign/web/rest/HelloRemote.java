package com.briup.demo10eurekasentinalfeign.web.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author lining
 * @Date 2022/11/10
 */
@FeignClient(name = "producer")
public interface HelloRemote {
    @GetMapping("/test")  // 远程调用：localhost:9001/test
    String test();
}
