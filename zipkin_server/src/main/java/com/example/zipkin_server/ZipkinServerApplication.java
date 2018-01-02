package com.example.zipkin_server;

/**
 * Spring-Cloud-Sleuth实例
 * ZipkinServer：服务链路追踪
 * user_service：应用服务，对外暴露接口
 * gateway_service:服务网关
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
/*服务
* 标明自己是个客户端*/
@EnableEurekaClient
/*开启Zipkin服务*/
@EnableZipkinServer
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
