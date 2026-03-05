package com.aranna.project5_e_commerce.model;

import com.aranna.project5_e_commerce.entity.Brand;
import com.aranna.project5_e_commerce.entity.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id;
    private String name; 
    private String description;
    private Long price;
    private byte[] image;
    private Brand brand;
    private Type type;
}
