package com.example.shopping.repository;

import com.example.shopping.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, String> {
    OrderStatus getOrderStatusByValue(String value);
}
