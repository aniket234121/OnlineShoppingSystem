package com.oss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oss.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
