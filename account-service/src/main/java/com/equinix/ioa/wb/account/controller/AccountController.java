package com.equinix.ioa.wb.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equinix.ioa.wb.account.model.User;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Qualifier("discoveryClient")
	@Autowired
	DiscoveryClient client;

	User user = null;
	
	public AccountController() {
		user = new User(100, "test@equinix.com", "Test");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET, produces ="application/json")
	public User login() {
		return user;
	}

	@RequestMapping(value = "/feign", method = RequestMethod.GET, produces ="application/json")
	public String feignMethod() {
		List<ServiceInstance> instances = client.getInstances("account-service");
		ServiceInstance selectedInstance = instances
				.get(new Random().nextInt(instances.size()));
		return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance
				.getHost() + ":" + selectedInstance.getPort();
	}


}