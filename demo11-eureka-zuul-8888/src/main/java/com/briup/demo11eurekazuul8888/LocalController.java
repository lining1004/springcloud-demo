package com.briup.demo11eurekazuul8888;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网关调用自己的controller返回信息
 * @Author lining
 * @Date 2022/11/10
 */
@RestController
public class LocalController {
    @GetMapping("/method")
    public String method(){
        return "zuul 自己的controller";
    }
}
