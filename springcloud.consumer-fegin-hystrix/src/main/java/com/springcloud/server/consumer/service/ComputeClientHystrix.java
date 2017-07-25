package com.springcloud.server.consumer.service;

import org.springframework.stereotype.Component;

@Component
public class ComputeClientHystrix implements ComputerClient {

	@Override
	public Integer add(Integer a, Integer b) {
		return -9999;
	}

}
