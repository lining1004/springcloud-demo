package com.briup.demo07consulconsumerfeign.web.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author lining
 * @Date 2022/11/8
 */
@FeignClient(name = "producer")
public interface HelloRemote {

    //producer  提供的可访问的接口决定： get localhost:9002/test?username=jack
    @GetMapping("/test")
    String test(@RequestParam("username") String username);
}
