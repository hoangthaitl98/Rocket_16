package com.example.shopping.service.impl;

import com.example.shopping.dto.OrderDto;
import com.example.shopping.entity.Order;
import com.example.shopping.entity.Product;
import com.example.shopping.entity.User;
import com.example.shopping.repository.OrderRepository;
import com.example.shopping.repository.OrderStatusRepository;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.UserRepository;
import com.example.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void addOrder(OrderDto orderDto) {
        Order order = new Order();
        List<Product> products = new ArrayList<>();
        order.setFullname(orderDto.getFullname());
        order.setAddress(orderDto.getAddress());
        order.setPhoneNumber(orderDto.getPhoneNumber());
        order.setEmail(orderDto.getPhoneNumber());
        order.setStatus(orderStatusRepository.getOrderStatusByValue("DAT_MOI"));

        for (int i = 0; i < orderDto.getProductIds().length; i++) {
            products.add(productRepository.findById(orderDto.getProductIds()[i]).get());
        }
        // order.setProducts(products);
        int id = orderRepository.save(order).getId();
        String subject = "Don hang" + id;
        String content = "Cua hang da nhan don hang " + id + "cua quy khach " + orderDto.getFullname()
                + "\n" + "Don hang cua quy khach bao gom: \n";
        for (int i = 0; i < orderDto.getProductIds().length; i++) {
            content = content.concat(products.get(i).getName() + "\t" + +products.get(i).getPrice() + "\n");
        }
        sendEmail("buihoangthaitl98@gmail.com", subject, content);
    }

    @Override
    public Order updateOrder(int id, OrderDto orderDto) {
        Order orderUpdate = orderRepository.findById(id).get();
        List<Product> products = new ArrayList<>();

        orderUpdate.setFullname(orderDto.getFullname());
        orderUpdate.setAddress(orderDto.getAddress());
        orderUpdate.setPhoneNumber(orderDto.getPhoneNumber());
        orderUpdate.setEmail(orderDto.getPhoneNumber());
        for (int i = 0; i < orderDto.getProductIds().length; i++) {
            products.add(productRepository.findById(orderDto.getProductIds()[i]).get());
        }
        //orderUpdate.setProducts(products);
        return orderRepository.save(orderUpdate);
    }

    @Override
    public Order updateStatus(int id, String statusValue) {
        Order order = orderRepository.findById(id).get();
        order.setStatus(orderStatusRepository.getOrderStatusByValue(statusValue));
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getByUser(String userId) {
        User user = userRepository.findById(userId).get();

        return user.getOrders();
    }

    private void sendEmail(final String recipientEmail, final String subject, final String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
