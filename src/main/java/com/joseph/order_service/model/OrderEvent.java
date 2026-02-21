package com.joseph.order_service.model;

public record OrderEvent(
        String orderId,
        String customerId,
        Double amount,
        String status
) {}