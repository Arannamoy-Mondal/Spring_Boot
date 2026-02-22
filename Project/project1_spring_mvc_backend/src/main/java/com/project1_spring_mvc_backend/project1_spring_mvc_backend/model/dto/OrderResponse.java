package com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(
    String orderId,
    String customerName,
    String email,
    String status,
    LocalDate orderDate,
    List<OrderItemResponse> items
) {

}
