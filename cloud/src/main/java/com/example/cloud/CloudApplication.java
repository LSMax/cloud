package com.example.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*服务提供者
* 当client向server注册时，它会提供一些元数据，
* 例如主机和端口，URL，主页等。
* Eureka server 从每个client实例接收心跳消息。 如果心跳超时，则通常将该实例从注册server中删除*/
@EnableEurekaClient
@SpringBootApplication
@RestController
public class CloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApplication.class, args);
	}
	@Value("${server.port}")
	String port;
	/*service-cloud工程*/
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:"+port;
	}

	@RequestMapping("/user")
	public String toUser(@RequestParam String name){
		return name;
	}
}
