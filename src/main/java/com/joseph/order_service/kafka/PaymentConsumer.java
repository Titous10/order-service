package com.joseph.order_service.kafka;

import com.joseph.order_service.model.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
    //@KafkaListener(topics = "orders", groupId = "payment-group")
    public void consume(OrderEvent event) throws InterruptedException {

        System.out.println("Processing payment: " + event.orderId());

        Thread.sleep(2000); // simulate real processing
    }
}
