package com.example.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
    public String hiService(String name) {
//        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://SERVICE-CLOUD/hi?name="+name,String.class);
    }

    /*
        @HystrixCommand：
        创建熔断器的功能，并指定了fallbackMethod熔断方法
    */
    @HystrixCommand(fallbackMethod = "hiError")
    public String tohiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
