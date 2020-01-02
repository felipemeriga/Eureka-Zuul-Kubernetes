package com.equinix.ioa.wb.feign.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.equinix.ioa.wb.feign.model.AccountService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equinix.ioa.wb.feign.model.Node;

@RestController
@RequestMapping("/node")
public class FeignController {

	@Autowired
	AccountService client;

	private List<Node> nodelist = new ArrayList<>();
	
	public FeignController() {
		nodelist.add(new Node(1, "Node1"));
		nodelist.add(new Node(2, "Node2"));
	}

	/**
	 * This is a demo API
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json" )
	public Node getNode(@PathVariable int id) {
		Optional<Node> node = nodelist.stream().filter(node1 -> node1.getId() == id).findFirst();
		return node.get();
	}

	@HystrixCommand(fallbackMethod = "fallBackMethod")
	@RequestMapping(value = "/feign", method = RequestMethod.GET, produces ="application/json")
	public String feignMethod() {
		return client.feignMethod();
	}

	@SuppressWarnings("unused")
	private String fallBackMethod() {
		return "Circuit Breaker enabled! No response from Account Service, service will be back shortly";
	}
}
