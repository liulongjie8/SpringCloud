package com.springcloud.server.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.springcloud.server.consumer.filter.AccessFilter;

/**
 * Provider 服务
 * 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
// 开启服务网关
public class CosumerApplication {

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(CosumerApplication.class, args);
	}
}
