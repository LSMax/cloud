package com.example.feign.service.impl;

import com.example.feign.service.SchedualService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class SchedualServiceHiHystric implements SchedualService {

    @Override
    public String sayHiFromClientOne(@RequestParam(value = "name") String name){
        return "sorry,"+name;
    }
}
