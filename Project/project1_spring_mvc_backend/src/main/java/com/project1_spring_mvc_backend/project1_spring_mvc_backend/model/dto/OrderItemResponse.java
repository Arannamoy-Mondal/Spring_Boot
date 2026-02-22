package com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.dto;

import java.math.BigDecimal;

public record OrderItemResponse(String productName,int quantity,BigDecimal subTotal) {

}
