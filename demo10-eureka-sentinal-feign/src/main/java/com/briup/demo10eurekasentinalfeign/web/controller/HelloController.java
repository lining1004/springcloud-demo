package com.briup.demo10eurekasentinalfeign.web.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.briup.demo10eurekasentinalfeign.web.rest.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lining
 * @Date 2022/11/10
 */
@RestController
public class HelloController {
    @Autowired
    private HelloRemote remote;


    /*
    * 开启 sentinel 监控
    * 设置埋点： 指定的方法上
    *
    * 1.进行流量控制，设置每秒 QPS访问量。当超过每秒访问的数量。
    * 后台抛出异常；指定一个方法，返回提示信息
    * 2.进行熔断降级：
    *    设置熔断条件：当服务无法访问发生异常，
    *    设置的单位时间内，异常个数超过5个。
    * 当用户前5次访问： 一直提示错误页面。
    * 当用户前6次访问： 提供blockhandler方法返回结果
    *  设置窗口时间：当65s过去后，熔断器关闭，允许用户可以
    *   通过/hello 远程调用：-- 提示error
    * 3.程序内部错误，抛出异常
    *   sentinel自动调用fallBack方法，默认返回处理结果
    * */
    @SentinelResource(value = "consumer-api",blockHandler = "blockHandler",fallback = "fallback")
    @GetMapping("/hello")
    public String hello() throws Exception{
        //当程序内部出现问题：
        System.out.println(1/0);
        return remote.test();
    }

    //用于流量控制返回默认结果
    //用于熔断降级返回默认结果
    public String blockHandler(BlockException ex){
        return "服务阻塞，等稍后重试:"+ex;
    }
    public String fallback(){
        return "当前服务内部错误,无法访问";
    }

}
