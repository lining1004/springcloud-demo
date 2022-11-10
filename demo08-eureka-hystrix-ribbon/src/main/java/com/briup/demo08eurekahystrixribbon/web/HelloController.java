package com.briup.demo08eurekahystrixribbon.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author lining
 * @Date 2022/11/10
 */
@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 设置熔断机制
     * 1.使用注解
     * 2.设置服务降级的方法
     * 3定义一个方法用来实现服务降级后，返回的结果
     * 4.模拟场景：
     *    1.producer不可用，直接调用熔断指定的默认方法返回结果
     *    2.producer 超时，Thread.sleep()
     *      设置最大的等待时间： 5s  5s自动进行熔断操作，调用默认的方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback",
                    commandProperties = @HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds", //属性名，设置服务A最大等待时间
                            value = "5000"  //属性值
                    ))
    @GetMapping("/hello")  //浏览器访问
    public String hello(){
        //远程调用服务B中的方法

        return restTemplate.getForObject("http://producer/test",String.class);
    }

    public String fallback(){
        System.out.println("进行服务降级处理");
        return "服务不可调用，请重试";
    }

}
