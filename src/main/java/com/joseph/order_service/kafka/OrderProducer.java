package com.joseph.order_service.kafka;

import com.joseph.order_service.model.Order;
import com.joseph.order_service.model.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducer {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    /*@Value("${app.kafka.topic}") private String topic;

    public void send(Order o) { kafka.send(topic, String.valueOf(o.getId()), o); }
    */


    public void send(OrderEvent event){
        kafkaTemplate.send("orders", event.orderId(), event);
    }
}
