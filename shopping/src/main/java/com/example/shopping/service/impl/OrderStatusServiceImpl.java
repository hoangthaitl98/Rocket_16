package com.example.shopping.service.impl;

import com.example.shopping.entity.OrderStatus;
import com.example.shopping.repository.OrderStatusRepository;
import com.example.shopping.service.OrderStatusService;
import com.example.shopping.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    private StringUtils stringUtils = new StringUtils();
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public List<OrderStatus> getAll() {
        List<OrderStatus> orderStatuses = orderStatusRepository.findAll();
        return orderStatuses;
    }

    @Override
    public OrderStatus createStatus(String status) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatus(status);
        orderStatus.setValue(stringUtils.toUppercaseNoSpace(status));
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus updateStatus(String id, String status) {
        OrderStatus orderStatus = orderStatusRepository.getById(id);
        orderStatus.setStatus(status);
        orderStatus.setStatus(stringUtils.toUppercaseNoSpace(status));
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public void deleteStatus(String id) {
        orderStatusRepository.deleteById(id);
    }
}
