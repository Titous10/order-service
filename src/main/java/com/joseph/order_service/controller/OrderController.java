package com.joseph.order_service.controller;

import com.joseph.order_service.kafka.OrderProducer;
import com.joseph.order_service.model.Order;
import com.joseph.order_service.repository.OrderRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderProducer producer;
    private final OrderRepository repo;

    @PostMapping("/place")
    public Order create(@RequestBody Order o) {
        Order saved = repo.save(o);
        producer.send(saved);
        return saved;
    }
}