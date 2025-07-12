package com.joseph.order_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")  // plural or another name
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue
    private String id;
    private String name;
}
