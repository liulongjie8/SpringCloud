package com.springcloud.server.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.server.consumer.service.ComputeService;

@RestController
public class ComputeController {

	@Autowired
	private ComputeService serivce;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return serivce.addService();
	}
}
