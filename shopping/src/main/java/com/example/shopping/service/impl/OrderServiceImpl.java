package com.example.shopping.service.impl;

import com.example.shopping.body.OrderBody;
import com.example.shopping.entity.Order;
import com.example.shopping.entity.Product;
import com.example.shopping.repository.OrderRepository;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void addOrder(OrderBody orderBody) {
        Order order = new Order();
        List<Product> products = new ArrayList<>();
        order.setFullname(orderBody.getFullname());
        order.setAddress(orderBody.getAddress());
        order.setPhoneNumber(orderBody.getPhoneNumber());
        order.setEmail(orderBody.getPhoneNumber());
        for (int i = 0; i < orderBody.getProductIds().length; i++) {
            products.add(productRepository.getById(orderBody.getProductIds()[i]));
        }
        orderRepository.save(order);
    }
}
