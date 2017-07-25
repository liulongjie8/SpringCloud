package com.springcloud.server.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputerClient {
	@RequestMapping(method = RequestMethod.GET, value = "/computer/add")
	Integer add(@RequestParam(value = "a") Integer a,
			@RequestParam(value = "b") Integer b);

}
