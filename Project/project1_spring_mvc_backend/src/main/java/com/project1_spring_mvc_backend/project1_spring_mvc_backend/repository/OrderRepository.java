package com.project1_spring_mvc_backend.project1_spring_mvc_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByOrderId(String orderId);

}
