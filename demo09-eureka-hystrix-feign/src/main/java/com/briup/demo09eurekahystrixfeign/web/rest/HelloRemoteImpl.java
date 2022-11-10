package com.briup.demo09eurekahystrixfeign.web.rest;

import org.springframework.stereotype.Component;

/**
 *  表示熔断机制触发后，调用的实现类的方法
 * @Author lining
 * @Date 2022/11/10
 */
@Component //创建服务降级方法调用对象
public class HelloRemoteImpl implements HelloRemote {
    public String test() {
        //服务降级后，固定的返回信息
        return "服务producer中断，不可访问";
    }
}
