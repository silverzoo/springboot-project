package com.elice.project.ch1105.practice3.repository;


import com.elice.project.ch1105.practice3.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
