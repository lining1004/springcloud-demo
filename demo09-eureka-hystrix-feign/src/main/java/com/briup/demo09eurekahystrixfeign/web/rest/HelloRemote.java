package com.briup.demo09eurekahystrixfeign.web.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 远程访问的服务信息：
 * localhost:9001/test  = producer/test
 * @Author lining
 * @Date 2022/11/10
 * 开启熔断机制，配置一个默认的执行方法，
 */
@FeignClient(name = "producer",fallback = HelloRemoteImpl.class)
public interface HelloRemote {
    @GetMapping("/test")
    String test();
}
