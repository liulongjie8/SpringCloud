package com.springcloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaServer
// 开启服务
public class ServerMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerMainApplication.class, args);
	}
}
