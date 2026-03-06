package com.aranna.project5_e_commerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name; 
    
    private String description;
    
    private Long price;

    @Lob
    @Column(columnDefinition = "LONGBLOB") 
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productBrandId", referencedColumnName = "Id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"}) 
   
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productTypeId", referencedColumnName = "Id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"})
    private Type type;   
}