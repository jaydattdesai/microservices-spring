package com.poc.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poc.order.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, String>{

}
