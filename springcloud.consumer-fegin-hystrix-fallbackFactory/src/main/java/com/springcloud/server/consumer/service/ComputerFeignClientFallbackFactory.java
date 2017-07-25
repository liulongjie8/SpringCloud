package com.springcloud.server.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class ComputerFeignClientFallbackFactory implements
		FallbackFactory<ComputerClient> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ComputerFeignClientFallbackFactory.class);

	@Override
	public ComputerClient create(final Throwable cause) {
		// TODO Auto-generated method stub
		return new ComputerClient() {
			@Override
			public Integer add(Integer a, Integer b) {
				ComputerFeignClientFallbackFactory.LOGGER.info(
						"fallback: reason was : ", cause);
				return -9999;
			}
		};
	}

}
