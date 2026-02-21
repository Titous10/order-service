package com.joseph.order_service.controller;

import com.joseph.order_service.kafka.OrderProducer;
import com.joseph.order_service.model.Order;
import com.joseph.order_service.model.OrderEvent;
import com.joseph.order_service.repository.OrderRepository;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.util.UUID;

@RestController
@RequestMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping
    public String create() {

        OrderEvent event = new OrderEvent(
                UUID.randomUUID().toString(),
                "cust-1",
                100.0,
                "CREATED"
        );

        producer.send(event);
        return "Order sent";
    }
}