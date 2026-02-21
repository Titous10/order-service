package com.joseph.order_service.kafka;

import com.joseph.order_service.model.OrderEvent;
import org.apache.kafka.clients.consumer.internals.Acknowledgements;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
    @KafkaListener(topics = "orders", groupId = "payment-group")
    public void consume(OrderEvent event, Acknowledgment ack) throws InterruptedException {
        processPayment(event);
        ack.acknowledge(); // commit ONLY after success
    }

    private void processPayment(OrderEvent event) throws InterruptedException{
        System.out.println("Processing payment: " + event.orderId());
        Thread.sleep(2000); // simulate real processing
    }
}
