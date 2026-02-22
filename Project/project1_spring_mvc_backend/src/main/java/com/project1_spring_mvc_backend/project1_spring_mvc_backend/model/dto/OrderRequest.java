package com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.dto;

import java.util.List;

public record OrderRequest(String customerName,
    String email,
    List<OrderItemRequest> orderItemRequest
) {
    
}
