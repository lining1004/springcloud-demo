package com.briup.demo11eurekazuul8888;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 服务降级操作
 * @Author lining
 * @Date 2022/11/10
 */
@Component
public class FallbackProducer implements FallbackProvider {
    public String getRoute() {
        //什么服务提供熔断操作？
        return "producer";
        //return  "*";  所有服务都提供统一熔断处理代码
    }
    //提供一个指定响应信息：
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            //返回状态码
            public HttpStatus getStatusCode() throws IOException {
                //服务不可用
                return HttpStatus.SERVICE_UNAVAILABLE;
            }
            //响应状态码
            public int getRawStatusCode() throws IOException {
                return HttpStatus.SERVICE_UNAVAILABLE.value();
            }
            //状态描述
            public String getStatusText() throws IOException {
                return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
            }

            public void close() {
                //未实现
            }

            public InputStream getBody() throws IOException {
                String msg = "服务不可用，请重试";
                return new ByteArrayInputStream(msg.getBytes());
            }

            public HttpHeaders getHeaders() {
                HttpHeaders header = new HttpHeaders();
                header.set("Content-Type","text/html;charset=utf-8");
                return header;
            }
        };
    }
}
