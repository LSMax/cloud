package com.example.server_center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerCenterApplication.class, args);
	}
}
