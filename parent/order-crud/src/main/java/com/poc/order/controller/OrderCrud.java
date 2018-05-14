package com.poc.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.order.model.Order;
import com.poc.order.repository.OrderRepository;

@RestController
public class OrderCrud {

	@Autowired
	OrderRepository orderRepository;

	@PostMapping(path = "/")
	public void createOrder(@RequestBody Order order) {
		orderRepository.save(order);
	}

	@GetMapping("/")
	public Iterable<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable String id) {
		return orderRepository.findOne(id);
	}

}
