package com.joseph.order_service.kafka;

import com.joseph.order_service.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducer {
    private final KafkaTemplate<String, Order> kafka;
    @Value("${app.kafka.topic}") private String topic;

    public void send(Order o) { kafka.send(topic, String.valueOf(o.getId()), o); }
}
