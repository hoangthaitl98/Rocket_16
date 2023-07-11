package com.example.shopping.service;

import com.example.shopping.dto.OrderDto;
import com.example.shopping.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();

    void addOrder(OrderDto orderDto);

    Order updateOrder(int id, OrderDto orderDto);

    Order updateStatus(int id, String statusValue);

    List<Order> getByUser(String userId);
}
