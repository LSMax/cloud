package com.example.feign.service;

import com.example.feign.util.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * configuration:可以自定义配置文件，也可以选择默认配置
 */
@FeignClient(value = "service-cloud",configuration = FeignConfig.class)
public interface SchedualServiceCloud {
    @GetMapping(value = "/hi")
    public String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
