package com.example.gateway_service.util;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

/**
 * 过滤器
 */
@Component
public class LoggerFilter extends ZuulFilter{
    @Autowired
    Tracer tracer;

    /**
     * 过滤类型为post
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//       通过addTag方法
        tracer.addTag("operator","forezp");
//        traceId作为唯一标识，可以存储于log日志中，方便查找
        System.out.print(tracer.getCurrentSpan().traceIdString());
        return null;
    }
}
