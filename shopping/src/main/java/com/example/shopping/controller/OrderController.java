package com.example.shopping.controller;

import com.example.shopping.dto.OrderDto;
import com.example.shopping.entity.Order;
import com.example.shopping.service.OrderService;
import com.example.shopping.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/v2/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping
    public ResponseEntity<?> getAllOrder() {
        List<Order> orders = orderService.getAllOrder();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateOrder(@PathVariable int id, @RequestBody OrderDto orderDto) {
        Order order = orderService.updateOrder(id, orderDto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("{id}/{statusValue}")
    public ResponseEntity<?> updateStatus(@PathVariable int id, @PathVariable String statusValue) {
        Order order = orderService.updateStatus(id, statusValue);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/getByUser")
    public ResponseEntity<?> getOrderByUser(HttpServletRequest request) {
        String userId = jwtUtils.getUserIdFromJWT(request.getHeader("Authorization").substring(7));
        List<Order> orders = orderService.getByUser(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
