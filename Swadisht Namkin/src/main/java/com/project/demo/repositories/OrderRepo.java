package com.project.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
