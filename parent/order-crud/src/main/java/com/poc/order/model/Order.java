package com.poc.order.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Order {

	private String id;
	
	private String itemName;
	
	private String orderQty;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}
}
