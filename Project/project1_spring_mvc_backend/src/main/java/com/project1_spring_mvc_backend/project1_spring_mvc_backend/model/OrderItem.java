package com.project1_spring_mvc_backend.project1_spring_mvc_backend.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    @ManyToOne
    private ProductModel product;
    private int quantity;
    private BigDecimal totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}
