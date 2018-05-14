package com.poc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderCrudApplication.class, args);
	}
}
