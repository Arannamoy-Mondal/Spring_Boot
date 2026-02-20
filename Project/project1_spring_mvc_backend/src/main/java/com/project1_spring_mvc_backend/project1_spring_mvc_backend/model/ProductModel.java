package com.project1_spring_mvc_backend.project1_spring_mvc_backend.model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @NotBlank(message = "Name Required")
    @Column(unique = true)
    private String name;
    @NotBlank(message = "Description Required")
    private String description;
    @NotBlank(message = "Brand Name")
    private String brand;
    @NotBlank(message = "Price ")
    private BigDecimal price;
    @NotBlank(message = "Category")
    private String category;
    @NotBlank(message = "Release Date")
    private Date releaseDate;
    @NotBlank(message = "Product Available")
    private boolean productAvailable;
    @NotBlank(message = "Stock Quantity")
    private int stockQuantity;
    
}
