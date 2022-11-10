package com.briup.demo11eurekazuul8888;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 身份认证拦截器
 * @Author lining
 * @Date 2022/11/10
 */
@Component
public class TokenFilter extends ZuulFilter {
    //设置过滤器类型： pre routing post exception
    public String filterType() {
        //当请求未被其他微服务处理前，进行拦截
        return FilterConstants.PRE_TYPE;
    }
    //设置拦截器的执行顺序，数值越小，顺序越前
    public int filterOrder() {
        return 0;
    }
    //是否启用该过滤器
    public boolean shouldFilter() {
        return true;
    }
    //过滤逻辑 定义该方法中
    public Object run() throws ZuulException {
        //1.通过请求对象获取请求头信息
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");

        //2.判断请求头token值是否为空 是否合法
        if(token == null){ //用户未登录，请登录后操作
            //不通过，响应提示信息
            ctx.getResponse().setContentType("text/html;charset=utf-8");
            ctx.setResponseBody("token无效，请重新登录");
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            ctx.setSendZuulResponse(false);//不继续转发请求给其他服务
        }else {
            //根据判断结果，通过,,进行访问
            ctx.setSendZuulResponse(true);
        }
        return null;//不做设置
    }
}
