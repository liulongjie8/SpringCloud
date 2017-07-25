package com.springcloud.server.consumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "ribbon-consumer", configuration = RibbonConfiguration.class)
public class TestRibbonConfiguration {

}
