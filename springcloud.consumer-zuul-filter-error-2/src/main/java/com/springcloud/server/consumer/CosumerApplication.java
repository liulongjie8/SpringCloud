package com.springcloud.server.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Provider 服务
 * 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
// 开启服务网关
public class CosumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosumerApplication.class, args);
	}
}
