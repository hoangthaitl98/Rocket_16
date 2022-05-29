package com.example.shopping.service;

import com.example.shopping.entity.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> getAllOrder();

    public void addOrder(Order order);
}
