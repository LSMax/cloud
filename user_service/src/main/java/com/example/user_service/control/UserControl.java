package com.example.user_service.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControl {

    @GetMapping("/demo")
    public String demo(){
        return "user zipkin";
    }

    @PostMapping("/filter")
    public String demoFilter(){
        return "filter post method";
    }
}
