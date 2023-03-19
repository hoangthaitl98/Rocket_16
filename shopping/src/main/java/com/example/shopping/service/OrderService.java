package com.example.shopping.service;

import com.example.shopping.body.OrderBody;
import com.example.shopping.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrder();

    public void addOrder(OrderBody orderBody);
}
