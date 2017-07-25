package com.springcloud.server.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.server.consumer.service.ComputerClient;

@RestController
public class ComputeController {

	@Autowired
	ComputerClient client;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add() {
		return client.add(10, 20);
	}
}
