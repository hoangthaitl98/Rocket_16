package com.example.shopping.service;

import com.example.shopping.entity.OrderStatus;

import java.util.List;

public interface OrderStatusService {
    List<OrderStatus> getAll();

    OrderStatus createStatus(String status);

    OrderStatus updateStatus(String id, String status);

    void deleteStatus(String id);
}
