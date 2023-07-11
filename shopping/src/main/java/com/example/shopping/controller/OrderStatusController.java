package com.example.shopping.controller;

import com.example.shopping.entity.OrderStatus;
import com.example.shopping.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/orderStatus")
@CrossOrigin("*")
public class OrderStatusController {
    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<OrderStatus> orderStatuses = orderStatusService.getAll();
        return new ResponseEntity<>(orderStatuses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createStatus(@RequestBody String status) {
        OrderStatus orderStatus = orderStatusService.createStatus(status);
        return new ResponseEntity<>(orderStatus, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable String id, @RequestBody String status) {
        OrderStatus orderStatus = orderStatusService.updateStatus(id, status);
        return new ResponseEntity<>(orderStatus, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteStatus(@PathVariable String id) {
        orderStatusService.deleteStatus(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }
}
