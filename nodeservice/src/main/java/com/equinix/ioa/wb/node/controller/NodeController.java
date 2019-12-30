package com.equinix.ioa.wb.node.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equinix.ioa.wb.node.model.Node;

@RestController
@RequestMapping("/node")
public class NodeController {
	
	private List<Node> nodelist = new ArrayList<>();
	
	public NodeController() {
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
}
